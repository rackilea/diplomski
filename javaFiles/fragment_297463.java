public int getColor(int i) {
          switch (i%8) {
             case 0: return Color.BLUE;
             case 1: return Color.RED;
             case 2: return Color.MAGENTA;
             case 3: return Color.GRAY;
             case 4: return Color.YELLOW;
             case 5: return Color.GREEN;
             case 6: return Color.CYAN;
             case 7: return 993399;
          }

          Random rnd = new Random(); 
          int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
          return color;      
       }