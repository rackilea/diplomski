byte[] buffer = new byte[hexString.length() / 2];
          int i = 2;
          while (i < hexString.length())
          {
              buffer[i / 2] = (byte)Integer.parseInt(hexString.substring(i, i + 2),16);
              i += 2;
          }