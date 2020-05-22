class TokenizingComparator implements Comparator<String> {
   private String separator;
   private static Pattern intPattern = Pattern.compile("[0-9]+");
   public TokenizingComparator(String separator) { this.separator = separator; }
   public int compare(String a, String b) {
      String pa[] = a.split(separator);
      String pb[] = b.split(separator);
      for (int ia=0, ib=0; ia<pa.length && ib<pb.length; ia++,ib++) {
          int rc = comparePart(pa[ia], pb[ib]);
          if (rc != 0) return rc;
      } 
      return (pa.length != pb.length) ? 
         pa.length - pb.length : 0;
   }
   private comparePart(String a, String b) {
      if (intPattern.matcher(a).matches() && intPattern.matcher(b).matches()) {
         return Integer.parseInt(a) - Integer.parseInt(b);
      } else {
         return a.compareTo(b);
      }
   }
}