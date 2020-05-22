public int compareTo(Song s) {
    int val = rating.compareTo(s.getRating());
      if(val == 0){
         val = title.compareTo(s.getTitle());
      }
    return val;
}