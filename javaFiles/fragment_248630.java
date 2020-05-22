case 'saturation':         
     int rgbMax = red > green ? (red > blue ? red : blue) : (green > blue ? green : blue);
     if(rgbMax == 0)
     {
         pixels[i]=Color.argb(alpha,0,0,0);
     }
     else
     {
         int rgbMin = red < green ? (red < blue ? red : blue) : (green < blue ? green : blue);
         int saturation = (255 * (rgbMax - rgbMin)) / rgbMax;
         pixels[i]=Color.argb(alpha,saturation,saturation,saturation);
     }