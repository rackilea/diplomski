for(int i = 0; i < 3; i++)
{
      customerColor = getstringInput(custColorMsg);
      String color = null 
      if( customerColor.equalsIgnoreCase("yes")) {
      color = true;
      break;
    }

      else if( customerColor.equalsIgnoreCase("no")) {
      color = true;
      break;
    }
      else{
      color = false;
    }
      custColorMsg = "Invalid Input, Please Input Again";
}