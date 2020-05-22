public void myfillRect(graphics page, int x, int y, int width, int height){
    if(width <0)
        x-=Math.abs(width);
    if(height <0)
        y-=Math.abs(height);

    page.rectfill(x,y,Math.abs(width), Math.abs(height));
}