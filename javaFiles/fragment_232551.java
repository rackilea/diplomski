enum ColorProperty {
    HUE {
        @Override
        public BufferedImage createImage(Color color, int w, int h, boolean panel) {
            BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

            if (panel) {
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                // float array is HSB
                float hue = Color.RGBtoHSB(red, green, blue, null)[0]; 

                for (int i = 0; i < h; i++) {
                    for (int j = 0; j < w; j++) {
                        float s = ((float) j) / (float) w;
                        float b = (h - (float) i) / (float) h;
                        int rgb = Color.getHSBColor(hue, s, b).getRGB();
                        img.setRGB(j, i, rgb);
                    }
                }
            } else {
                for (int i = 0; i < h; i++) {
                    for (int j = 0; j < w; j++) {
                        float hue = (h - (float) i) / (float) h;
                        int rgb = Color.getHSBColor(hue, 1f, 1f).getRGB();
                        img.setRGB(j, i, rgb);
                    }
                }
            }
            return img;
        }
    },
    SATURATION {
        @Override
        public BufferedImage createImage(Color color, int w, int h, boolean panel) {
            BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            int red = color.getRed();
            int green = color.getGreen();
            int blue = color.getBlue();
            // float array is HSB
            float[] hsb = Color.RGBtoHSB(red, green, blue, null);

            return panel ? createPanelImg(w, h, img, hsb) : createBarImg(w, h, img, hsb);
        }

        private BufferedImage createBarImg(int w, int h, BufferedImage img, float[] hsb) {
            float hue = hsb[0];
            // float brightness = hsb[2];
            float brightness = 1f;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    float saturation = (h - (float) i) / (float) h;
                    int rgb = Color.getHSBColor(hue, saturation, brightness).getRGB();
                    img.setRGB(j, i, rgb);
                }
            }
            return img;
        }

        private BufferedImage createPanelImg(int w, int h, BufferedImage img, float[] hsb) {
            float saturation = hsb[1]; 
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    float hue = ((float) j) / (float) w;
                    float b = (h - (float) i) / (float) h;
                    int rgb = Color.getHSBColor(hue, saturation, b).getRGB();
                    img.setRGB(j, i, rgb);
                }
            }            
            return img;
        }
    },
    BRIGHTNESS {
        @Override
        public BufferedImage createImage(Color color, int w, int h, boolean panel) {
            BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            int red = color.getRed();
            int green = color.getGreen();
            int blue = color.getBlue();
            // float array is HSB
            float[] hsb = Color.RGBtoHSB(red, green, blue, null);

            return panel ? createPanelImg(w, h, img, hsb) : createBarImg(w, h, img, hsb);
        }

        private BufferedImage createBarImg(int w, int h, BufferedImage img, float[] hsb) {
            float hue = hsb[0];
            // float saturation = hsb[1];
            float saturation = 1f;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    float brightness = (h - (float) i) / (float) h;
                    int rgb = Color.getHSBColor(hue, saturation, brightness).getRGB();
                    img.setRGB(j, i, rgb);
                }
            }
            return img;
        }

        private BufferedImage createPanelImg(int w, int h, BufferedImage img, float[] hsb) {
            float brightness = hsb[2]; 
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    float hue = ((float) j) / (float) w;
                    float saturation = (h - (float) i) / (float) h;
                    int rgb = Color.getHSBColor(hue, saturation, brightness).getRGB();
                    img.setRGB(j, i, rgb);
                }
            }            
            return img;
        }
    };

    public abstract BufferedImage createImage(Color color, int w, int h, boolean panel);
}