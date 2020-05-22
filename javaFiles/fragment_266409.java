for (int i=0; i<bytearray1.length; i++) {               
                    builder1.append((int)bytearray1[i] &0xff);      
                    if(i != bytearray1.length) 
                        builder1.append("• ");
                }
            }