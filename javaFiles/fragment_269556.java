wvContent = (WebView) findViewById(R.id.wvContent);
int bg_color=Color.TRANSPARENT;
 if("Red".equals(items[which]))
   {
       wvContent.setBackgroundColor(Color.RED);
       bg_color=Color.RED;
   }
 else if("Green".equals(items[which]))
  {
      wvContent.setBackgroundColor(Color.GREEN);
       bg_color=Color.GREEN;
  }
........
// save color in SharedPreferences
 saveSelectedItem(bg_color);