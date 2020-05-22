System.out.println("Write year between 1950-2050: ");
         int keyboard = input.nextInt();
         int OL = (keyboard);
         int WC = (keyboard);
         int nothingspec = (keyboard);
         int instru = (keyboard);
         boolean blOL = false;
         boolean blWC = false;
         //this occurs whenever the number can be divided by 4
         if(keyboard>=1950&&keyboard<=2050){
            if(OL%4==0) { 

             System.out.println("Yes this year it the olympic games. ");
            blOL=true;
            }      
            //This will happen every time the date can be divided to 2 so as               you said 2002, 2004, 2006 and so on. 
            else if(WC%2==0) { 

                System.out.println("Yes this year it was a world cup in   soccer.");
            blWC = true;
            }
            //This is when nothing has happend.     
            else if(blOL==false && blWC==false) {

             System.out.println("This year nothing special happened.");

            }
            else{

                System.out.println("Your instructions were wrong please try again.");
            }
          }
          else{

                System.out.println("Your instructions were wrong please try again.");
            }


    input.close();