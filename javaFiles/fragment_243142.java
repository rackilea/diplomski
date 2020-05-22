String inputText = ("iwanttoknowrelatedtoAdvancejava").toLowerCase().replaceAll("\\s", "");
    String match = "java"; 
     List<String> keywordsList = session.createSQLQuery("SELECT QUESTIONARIES_RAISED FROM QUERIES").list();  // Fetch values from database (advance,core,programming)
    String uniqueKeyword=null;
    String commonKeyword= null;
    int size =keywordsList.size();
    for(int i=0;i<size;i++){
               String s1 = (String) keywordsList.get(i);//get values one by one from list
    if(inputText.contains(match)){
    if(inputText.contains(s1) && inputText.contains(match)){
    Queries q1 = new Queries();
    q1.setQuestionariesRaised(s1); //set matched keyword to getter setter method
    keywordsList1=session.createQuery("from Queries sentence where questionariesRaised='"+q1.getQuestionariesRaised()+"'").list(); // based on matched keyword fetch according to matched keyword sentence which stored in database
    for(Queries ob  : keywordsList1){

    uniqueKeyword=  ob.getSentence().toString();// Store fetched sentence to on string variable
      }
    break;
    }else {
      commonKeyword= "java only"; 
         }
       }
     }}
  if(uniqueKeyword!= null){
   System.out.println("Yes we providing......................" + uniqueKeyword);        
  }else if(commonKeyword!= null){
   System.out.println("Yes we providing " + commonKeyword);
    }else{      
}