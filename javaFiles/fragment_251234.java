switch(hpSelect){
        case 1:
            System.out.print(volMessage);
            int volSelect = input.nextInt();
            if (volSelect == 1){
                h1.changeVolume(LOW);
                System.out.println("\n" + h1);   
            }; break;    

        case 2:
            System.out.print(volMessage);
            volSelect = input.nextInt();
            if (volSelect == 2){
                h1.changeVolume(MEDIUM);
                System.out.println("\n" + h2);
            }; break;

        case 3:
            System.out.print(volMessage);
            volSelect = input.nextInt();
            if (volSelect == 3){
                h1.changeVolume(HIGH);
                System.out.println("\n" + h3);
            }; break;

        default:
            System.out.println("Invalid entry.");
            break;



   }//End switch statement