byte b;
                int disponibles = input.available();
                byte[] rawData = new byte[disponibles];
                int count = 0;
                while ((b = (byte) input.read()) != -1) {
                    if (count == disponibles - 1) {
                        break;
                    }
                    rawData[count] = b;
                    count++;
                }