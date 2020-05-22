XSSFColor color = font.getXSSFColor();
        if(color != null) {
            fontFmt.setFontColor(color);
            //Themed color is not handed properly by poi. Hence have to handle it below.
            if(color.isThemed()) {
                CTFont ctFont = (CTFont) getFieldValWithReflection(fontFmt,"_font");
                if(ctFont != null && ctFont.sizeOfColorArray()>0){
                    CTColor c = ctFont.getColorArray(0);
                    if(color.hasTint())
                        c.setTint(font.getXSSFColor().getTint());
                    if(color.isIndexed())
                        c.setIndexed(color.getIndexed());
                }
            }
        }

    /**
     * Helper for the very common case of having to get underlying XML data.
     */
    private Object getFieldValWithReflection(Object owner, String fieldName) {
        Field f = null;
        Object val = null;
        try {
            f = owner.getClass().getDeclaredField(fieldName);
            f.setAccessible(true);

            val = f.get(owner);
            return val;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (f != null) {
                f.setAccessible(false);
            }
        }

        return null;
    }