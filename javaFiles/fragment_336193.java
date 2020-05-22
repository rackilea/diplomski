DecimalFormat df = new DecimalFormat("$#,###.##");  
                        df.format(clearance);                        
                        salePrice.setText(df.format(clearance));                                         
                        //salePrice.setText(df.toString());  //output to JTextField    
                        System.err.println(df.toString());
                    }
                });