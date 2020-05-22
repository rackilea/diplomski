int w = bitmap.getWidth();                                          
int h = bitmap.getHeight();                                         

int radius = Math.min(h / 2, w / 2);                                
Bitmap output = Bitmap.createBitmap(w + 8, h + 8, Config.ARGB_8888);

Paint p = new Paint();                                              
p.setAntiAlias(true);                                               

Canvas c = new Canvas(output);                                      
c.drawARGB(0, 0, 0, 0);                                             
p.setStyle(Style.FILL);                                             

c.drawCircle((w / 2) + 4, (h / 2) + 4, radius, p);                  

p.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));                 

c.drawBitmap(bitmap, 4, 4, p);                                      
p.setXfermode(null);                                                
p.setStyle(Style.STROKE);                                           
p.setColor(Color.WHITE);                                            
p.setStrokeWidth(3);                                                
c.drawCircle((w / 2) + 4, (h / 2) + 4, radius, p);                  

return output;