private void setFramePaint(Paint p, int side, float iw, float ih){
                // paint, side of rect, image width, image height

                p.setShader(null);
                p.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));

                float borderSize = 0.1f; //relative size of border
                //use the smaller image size to calculate the actual border size
                float bSize = (iw > ih)? ih * borderSize: ih * borderSize; 
                float g1x = 0;
                float g1y = 0;
                float g2x = 0;
                float g2y = 0;
                int c1 = 0, c2 = 0;

                if (side == 1){
                    //left
                    g1x = 0;
                    g1y = ih/2;
                    g2x = bSize;
                    g2y = ih/2;
                    c1 = Color.TRANSPARENT;
                    c2 = Color.BLACK;

                }else if(side == 2){
                    //top
                    g1x = iw/2;
                    g1y = 0;
                    g2x = iw/2;
                    g2y = bSize;
                    c1 = Color.TRANSPARENT;
                    c2 = Color.BLACK;


                }else if(side == 3){
                    //right
                    g1x = iw;
                    g1y = ih/2;
                    g2x = iw - bSize;
                    g2y = ih/2;
                    c1 = Color.TRANSPARENT;
                    c2 = Color.BLACK;


                }else if(side == 4){
                    //bottom
                    g1x = iw/2;
                    g1y = ih;
                    g2x = iw/2;
                    g2y = ih - bSize;
                    c1 = Color.TRANSPARENT;
                    c2 = Color.BLACK;
                }

                p.setShader(new LinearGradient(g1x, g1y, g2x, g2y, c1, c2, Shader.TileMode.CLAMP));

            }