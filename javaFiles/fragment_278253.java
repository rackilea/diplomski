public String getHexFromInt(int val){
     StringBuilder sb = new StringBuilder();
     sb.append(Integer.toHexString(val));
     if (sb.length() < 2) {
         sb.insert(0, '0'); // add leading zero if necessary
     }
     String hex = sb.toString();

     return hex;
}