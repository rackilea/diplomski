List<String> list = Arrays.asList(X);
while((ListChecker.hasNext())) {   //continues as long as DNA Check has an index to go to 
   if (list.contains(ListChecker.next())) {                  //Checks A for X
       System.out.println("Good");       //Prints out good if the check is good
   } else {
       System.out.println("Bad");        //Prints out bad if the check is bad
   }
}