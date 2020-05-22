String numberS = "1,332.0";
String numberE = "10";
     try {
         String newNumberS = numberS.replace(",",  "");
         double value = Double.parseDouble(nNumberS) * Double.parseDouble(numberE);
         log.i("tag", "value: "+value);
     } catch (NumberFormatException e) {
            //catch exception here, if occur.
     }