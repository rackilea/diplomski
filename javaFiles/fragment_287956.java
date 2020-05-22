frameView.setOnMouseClicked(Event->{Mat m= new Mat();
                                                double[] pixel=new double[3];

                                                float[] hsv = new float[3];

                                                grabMat(0).convertTo(m, CvType.CV_8U);
                                                Imgproc.cvtColor(m, m, Imgproc.COLOR_BGR2RGB, 3);

                                                pixel=m.get((int)Event.getX(),(int)Event.getY());

                                                red=pixel[0];
                                                green=pixel[1];
                                                bleu=pixel[2];
                                            System.out.println("X= "+Event.getX()+"Y="+Event.getY()+"---red= "+red+"---bleu= "+bleu+"---green= "+green);
                                            hsv=java.awt.Color.RGBtoHSB((int)red,(int)green,(int)bleu, null);
                                            h= hsv[0];
                                            s=hsv[1];
                                            v=hsv[2];
                                                System.out.println("h= "+h+"---s= "+s+"---v= "+v);


                                                });