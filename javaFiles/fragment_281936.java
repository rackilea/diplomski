public void threadB() {
     List<String> K = list;
     for(String s : K) {
         System.out.println(s);
     }
}