protected void doPost(...){
   FruitDao fdao = new FruitDao(); // get the db class for fruits
   String fruit = request.getParameter("fruit");
   String color = request.getParameter("color");

   //unless you wanna complicate things, i would create a string out of the two parameters and store it into an arraylist of strings
   String value = fruit+color; 

   HttpSession session = (request.getSession()); //get session
   if(null == session.getAttribute("duplicates")){ //if session variable empty then we know that user has not submitted anything yet so we let them insert into db

     fdao.insertFruit(fruit,color); //add to db

     ArrayList<String> duplicates = new ArrayList<String>(); //create arraylist
     duplicates.add(value); //add our unique value
     session.setAttribute("duplicates", duplicates); //set as session variable

    }else{
     //here the session variable is not empty so that means the user has already submitted something so lets check the arraylist and make sure the value does not already exist

     ArrayList<String> duplicates = (ArrayList<String>) session.getAttribute("duplicates");

     if(!duplicates.contains(value)){
      //if arraylist does not contain the same value, then it's safe to add
        fdao.insertFruit(fruit,color); //add to db

      //forgot this part
      duplicates.add(value);
      session.setAttribute("duplicates", duplicates); //update the variable
     }


    }


   response.sendRedirect("results?ADD=SUCCESS");
}