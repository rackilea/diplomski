int A=0, B=0, C=0, D=0, color=0, ncolor=0;

for(int i=0; i<width; i++)
{
    for(int j=0; j<height; j++)
    {
        color = bitmap.getPixel(i,j);
        A = (color >> 24) & 0xff; // Get Alpha
        R = (color >> 16) & 0xff;
        G = (color >>  8) & 0xff;
        B = (color) & 0xff;
        A = A/2; //REDUCE BY HALF SO DIVIDE BY 2(50%)
        ncolor = (A & 0xff) << 24 | (R & 0xff) << 16 | (G & 0xff) << 8 | (B & 0xff);
        bitmap.setPixel(i,j,ncolor);
    }
}