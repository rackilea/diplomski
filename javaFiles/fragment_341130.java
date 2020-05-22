matrixPortrayal.setPortrayalForAll(new OvalPortrayal2D() {
        public void draw(Object object, Graphics2D graphics, DrawInfo2D info) {
            MutableDouble valueObj = (MutableDouble)object;
            if ( valueObj.intValue() == 0 ) {
                paint = new java.awt.Color(1.0F,0.0F,0.0F,0.0F);
            } else {
                paint = new java.awt.Color(1.0F,0.0F,0.0F,1.0F);
            }
            filled = true;
            super.draw(object, graphics, info);
        }

    });