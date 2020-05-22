public static void drawString(Graphics g, String s, int x, int y, int width,int red_val,int green_val, int blue_val, int lineHeight )
    {     FontMetrics fm = g.getFontMetrics();
          java.awt.Color c= new java.awt.Color(red_val, green_val, blue_val);
          g.setColor(c);
          int curX = x;
          int curY = y;
      String[] words = s.split(" ");
            for (String word : words)
            {
                    // Find out thw width of the word.
                    int wordWidth = fm.stringWidth(word + " ");

                    // If text exceeds the width, then move to next line.
                    if (curX + wordWidth >= x + width)
                    {
                            curY += lineHeight;
                            curX = x;
                    }
                    g.drawString(word, curX, curY);
                    // Move over to the right for next word.
                    curX += wordWidth;
            }
    }