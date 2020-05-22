public void printUnsolvedIssue() {

   for(int m=0; m<solvedIss.length;m++){
       crIss.remove(solvedIss[i]);
   }

   for(int i = 0; i < crIss.size(); i++) {
       System.out.print(crIss.get(i));
       // only print the delimiter if it isn't the last item in the list
       if(i < crIss.size() - 1) {
           System.out.print(", ");
       }
   }
}