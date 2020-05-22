List<Boolean> list = model.getBooleanData();
               Boolean[] inputSleep = new Boolean[list.size()];
               inputSleep = list.toArray(inputSleep);


               byte[] toReturn = new byte[inputSleep.length / 8];
               for (int entry = 0; entry < toReturn.length; entry++) {
                   for (int bit = 0; bit < 8; bit++) {
                       if (inputSleep[entry * 8 + bit]) {
                           toReturn[entry] |= (128 >> bit);
                       }
                   }
               }