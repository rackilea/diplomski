for(int i = 0; i < mArrSearchAutoSuggest.length; i++) {
  SearchAutoSuggestResult result = mArrSearchAutoSuggest[i];
  String res = result.getRes();
  if(res != null && res.equals("Hello") { //means the result exists ans its value is "Hello"
    System.out.print(res);
    System.out.println(i); //prints the position of result  in the array
  }
}