if ((hexString.length()) % 2 > 0)
          throw new NumberFormatException("Input string was not in a correct format.");
       int[] buffer = new int[hexString.length() / 2];
          int i = 2;
          while (i < hexString.length())
          {
              buffer[i / 2] = Integer.parseInt(hexString.substring(i, i + 2),16);
              i += 2;
          }