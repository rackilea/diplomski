while(num >= 0)
    {
    // input question after a character is inputted
       System.out.println("Please input a number: ");
       sumNumbers = myInput.readLine();
       try{
            num = Double.parseDouble (sumNumbers);
            total = total + num;
            System.out.println(total);
       } catch(Exception e)
       {
            System.out.println("Please enter a proper number");
       }    


            // ending statement
  }