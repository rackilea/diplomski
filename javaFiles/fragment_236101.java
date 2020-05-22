for(int x=0; x<pixels.length; x++)
{
    for(int k=0;k< pixels[0].length; k++)
    {   
        X=gx*Math.cos(theta)+gy*Math.sin(theta);
        Y=-gx*Math.sin(theta)+gy*Math.cos(theta);

        pixels[dy][ax]=((Math.exp(-(Math.pow(X, 2)+(Math.pow(Y, 2)*
                Math.pow(upsi,2)))/(2*Math.pow(sigma, 2))))*
                (Math.cos((kappa*X+varphi))));