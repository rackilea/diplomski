for(int y = 0; y < bounds.height ; y++)
                {
                    for (int x = 0; x < bounds.width ; x++) {
                        int pixelRGB = img.getRGB(x, y);
                        int newX = x;
                        int newY = ((int)(Math.sin(x*Math.PI/bounds.width) * 40 )) + y  ;
                        newImg.setRGB(newX, newY, pixelRGB);            
                    }
                }