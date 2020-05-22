char selection;
do
{
    do
    {
        //Menu
        System.out.println("Toll Road Data Entry Menu");
        System.out.println("-----------------------------------------");

        System.out.println("A - Record Trip");
        System.out.println("B - Record Breakdown Incident");
        System.out.println("X - Exit");

        System.out.print("Enter Your Selection: ");
        selection = input.nextChar(); 
        if (selection!='a' || selection!='A' || selection!='b' || selection!='B' || selection!='x' || selection!='X') 
        { 
            System.out.println("Selection must be a single character, A,B or X");
            continue;
        }
        else
            break;
    } while (1);

    switch(selection)
    {
        case 'A':
        case 'a':
            System.out.print("Enter a Trip Date: ");
            date = input.nextLine();

            System.out.print("Enter Trip Point: ");
            enter_point = input.nextLine();

            System.out.print("Enter Exit Point: ");
            exit_point = input.nextLine();
            break;
        case 'B':
        case 'b':
            System.out.print("Enter Breakdown Date: ");
            breakdown = input.nextLine();

            System.out.print("Enter Sector Breakdown Occured in: ");
            sector_break = input.nextInt();

            System.out.print("Enter Vehicle Recovery Cost: ");
            rec_cost = input.nextDouble();
            break;
        case 'x':
        case 'X':
            System.out.println("Exiting data entry menu..");
            break;
        //equivalent to an else
        default:
            System.out.println("ERROR! - Please Enter a Valid Selection!");
    }   
} while(selection != 'X');