import javax.swing.*;
import javax.swing.text.*;


public class WrapApp extends JFrame {
    JEditorPane edit=new JEditorPane();
    public WrapApp() {
        super("Wrap in the mid");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        edit.setEditorKit(new WrapEditorKit());
        edit.setText("111 222 333333333333333333333333333333333333333333333");

        getContentPane().add(new JScrollPane(edit));
        setSize(200,200);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        WrapApp m = new WrapApp();
        m.setVisible(true);
    }


}

class WrapEditorKit extends StyledEditorKit {
    ViewFactory defaultFactory=new WrapColumnFactory();
    public ViewFactory getViewFactory() {
        return defaultFactory;
    }

}

class WrapColumnFactory implements ViewFactory {
    public View create(Element elem) {
        String kind = elem.getName();
        if (kind != null) {
            if (kind.equals(AbstractDocument.ContentElementName)) {
                return new WrapLabelView(elem);
            } else if (kind.equals(AbstractDocument.ParagraphElementName)) {
                return new ParagraphView(elem);
            } else if (kind.equals(AbstractDocument.SectionElementName)) {
                return new BoxView(elem, View.Y_AXIS);
            } else if (kind.equals(StyleConstants.ComponentElementName)) {
                return new ComponentView(elem);
            } else if (kind.equals(StyleConstants.IconElementName)) {
                return new IconView(elem);
            }
        }

        // default to text display
        return new LabelView(elem);
    }
}

class WrapLabelView extends LabelView {
    public WrapLabelView(Element elem) {
        super(elem);
    }

    public int getBreakWeight(int axis, float pos, float len) {
        if (axis == View.X_AXIS) {
            checkPainter();
            int p0 = getStartOffset();
            int p1 = getGlyphPainter().getBoundedPosition(this, p0, pos, len);
            if (p1 == p0) {
                // can't even fit a single character
                return View.BadBreakWeight;
            }
            return View.GoodBreakWeight;
        }
        return super.getBreakWeight(axis, pos, len);
    }
    public float getMinimumSpan(int axis) {
        switch (axis) {
            case View.X_AXIS:
                return 0;
            case View.Y_AXIS:
                return super.getMinimumSpan(axis);
            default:
                throw new IllegalArgumentException("Invalid axis: " + axis);
        }
    }

    public View breakView(int axis, int p0, float pos, float len) {
        if (axis == View.X_AXIS) {
            checkPainter();
            int p1 = getGlyphPainter().getBoundedPosition(this, p0, pos, len);
            GlyphView v = (GlyphView) createFragment(p0, p1);
            return v;
        }
        return super.breakView(axis, p0, pos, len);
    }
}