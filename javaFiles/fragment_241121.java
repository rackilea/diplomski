public String reverseMask(String mask) {
       String[] octets = mask.split("\\.");
       StringBuilder sb = new StringBuilder();
       for (int i=0;i<4;i++) {
         sb.append(String.valueOf(0xFF ^ Integer.valueOf(octets[i])))
           .append(i==3 ? "" : ".");
       }
       return sb;
    }