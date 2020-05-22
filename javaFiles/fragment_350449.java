import javax.swing.*;
import javax.swing.text.Element;
import javax.swing.text.ParagraphView;
import javax.swing.text.View;
import javax.swing.text.ViewFactory;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.InlineView;
import java.awt.*;

/**
 * A fixed HTML Editor Kit, which fixes two things:
 * - Word wrapping of long words (bugged in Java 7)
 * - A hanging indent bug
 */
public class FixedHtmlEditorKit extends HTMLEditorKit {

@Override
public ViewFactory getViewFactory() {
    return new HTMLEditorKit.HTMLFactory() {
        public View create(Element e) {
            View v = super.create(e);

            if (v instanceof InlineView) {
                return new InlineView(e) {
                    public int getBreakWeight(int axis, float pos, float len) {
                        return GoodBreakWeight;
                    }

                    public View breakView(int axis, int p0, float pos, float len) {
                        if (axis == View.X_AXIS) {
                            checkPainter();
                            int p1 = getGlyphPainter().getBoundedPosition(this, p0, pos, len);
                            if (p0 == getStartOffset() && p1 == getEndOffset()) {
                                return this;
                            }
                            return createFragment(p0, p1);
                        }
                        return this;
                    }
                };
            }
            else if (v instanceof ParagraphView) {
                return new ParagraphView(e) {
                    protected SizeRequirements calculateMinorAxisRequirements(int axis, SizeRequirements r) {
                        if (r == null) {
                            r = new SizeRequirements();
                        }
                        float pref = layoutPool.getPreferredSpan(axis);
                        float min = layoutPool.getMinimumSpan(axis);
                        // Don't include insets, Box.getXXXSpan will include them.
                        r.minimum = (int) min;
                        r.preferred = Math.max(r.minimum, (int) pref);
                        r.maximum = Integer.MAX_VALUE;
                        r.alignment = 0.5f;
                        return r;
                    }

                    private boolean allowedToPaintFirstView = true;

                    private float tabBase;

                    /*
                     * We need to override this since tabBase is private in ParagraphView.
                     */
                    @Override
                    protected float getTabBase() {
                        return tabBase;
                    }

                    @Override
                    protected void paintChild(Graphics g, Rectangle alloc, int index) {
                        // Don't paint the first index twice!
                        if (index == 0 && !allowedToPaintFirstView) {
                            return;
                        }
                        super.paintChild(g, alloc, index);
                    }


                    public void paint(Graphics g, Shape a) {
                        Rectangle alloc = (a instanceof Rectangle) ? (Rectangle)a : a.getBounds();

                        tabBase = alloc.x + getLeftInset();

                        // line with the negative firstLineIndent value needs
                        // special handling
                        if (firstLineIndent < 0) {
                            Shape sh = getChildAllocation(0, a);
                            if ((sh != null) &&  sh.intersects(alloc)) {
                                int x = alloc.x + getLeftInset() + firstLineIndent;
                                int y = alloc.y + getTopInset();

                                Rectangle clip = g.getClipBounds();
                                Rectangle tempRect = new Rectangle();
                                tempRect.x = x + getOffset(X_AXIS, 0);
                                tempRect.y = y + getOffset(Y_AXIS, 0);
                                tempRect.width = getSpan(X_AXIS, 0) - firstLineIndent;
                                tempRect.height = getSpan(Y_AXIS, 0);
                                if (tempRect.intersects(clip)) {
                                    tempRect.x = tempRect.x - firstLineIndent;
                                    allowedToPaintFirstView = true;
                                    paintChild(g, tempRect, 0);
                                    allowedToPaintFirstView = false;
                                }
                            }
                        }

                        super.paint(g, a);
                    }
                };
            }
            return v;
        }
    };
}