byte[] bytes = column.getBytes();

                  for (int x = 0; x < bytes.length; x++) {
                      int index = (0xff) & bytes[x];
                      char c = getKamenickyCharTable()[index];
                  }