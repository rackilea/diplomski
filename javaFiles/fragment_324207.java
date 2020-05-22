int adjustColor(int itemColor)
  {
     int adjustedColor;

     int R = Color.red(itemColor);
     int B = Color.blue(itemColor);
     int G = Color.green(itemColor);

     adjustedColor = Color.rgb(R/2,G/2,B/2);
     return adjustedColor;
  }