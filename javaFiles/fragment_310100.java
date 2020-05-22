//            Passing an integer 'g' into the function here |
//                                                          V
public void drawString(String str, int x, int y, int r, int g, int b){
//  | This 'g' is the integer you passed in
//  V
    g.setColor(r, g, b);
    g.drawString(str, x, y, 0);
}