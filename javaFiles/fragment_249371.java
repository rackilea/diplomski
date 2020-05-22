public class MyHTMLEditorKit extends HTMLEditorKit {

    @Override
    public ViewFactory getViewFactory() {

        return new HTMLEditorKit.HTMLFactory() {

            public View create(Element e) {

                View v = super.create(e);

                Object o = e.getAttributes().getAttribute(StyleConstants.NameAttribute);

                if (o instanceof HTML.Tag) {

                    HTML.Tag kind = (HTML.Tag) o;

                    if (kind == HTML.Tag.IMG) {
                        return new MyImageView(e);
                    }
                }

                if (v instanceof InlineView) {

                    return new InlineView(e) {

                        public int getBreakWeight(int axis, float pos, float len) {
                            return View.GoodBreakWeight;
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
                } else if (v instanceof ParagraphView) {

                    return new ParagraphView(e) {

                        protected javax.swing.SizeRequirements calculateMinorAxisRequirements(int axis, javax.swing.SizeRequirements r) {

                            if (r == null) {
                                r = new javax.swing.SizeRequirements();
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

                    };
                }

                return v;
            }
        };
    }
}