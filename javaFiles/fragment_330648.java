String response = ans.nextLine();
while (true) {
  if (response.equalsIgnoreCase("Yes")){
    System.out.println("Woof :-)");
    break;
  }else if(response.equalsIgnoreCase("No")){
    System.out.println("Grrrr :-(");
    break;
  }else{  
    System.out.println("What? Please try again.");
    response = ans.nextLine();
  }   
}