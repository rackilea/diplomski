while (ans == false) {  // start of while block
          System.out.println("Do you want to try again?");
          ans0 = KeyBoard.nextLine();
          ans0 = ans0.toLowerCase();
          switch(ans0){
            case "no":
              playing = false;
            case "yes":
              ans = true;
          }
        }    // end of while block