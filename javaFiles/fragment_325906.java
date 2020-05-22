public static void main(String[] args) 
{
    String name; //declaring string name
    String town; //declaring string town
    double dist; //declaring double distance from AIT the person lives
    int age; //declaring their age 
    double height; //declaring their height
    double weight; //declaring their weight
    String country; //declaring their country that they are from
    String course; //declaring their course that they are taking 
    int years; //declaring the amount of years they are in the course
    String sNum; //declaring there email address string

    Scanner f = new Scanner(System.in);
    //Scanner s = new Scanner(System.in);
    // below is the prompt for all the information and there keyboard input with scanner
    System.out.print("Enter your name here & press enter: "); 
    name = f.nextLine();

    System.out.print("Enter the name of the town or city you live in & press enter: ");
    town = f.nextLine();

        System.out.print("Enter the name of country that you are from & press enter: ");
    country = f.nextLine();

    System.out.print("Enter the name of course you are taking & press enter: ");
    course = f.nextLine();

    System.out.print("Enter the number of years the course is & press enter: ");
    years = f.nextInt();

    System.out.print("Enter your student number & press enter: ");
    sNum = f.next();

    System.out.print("Enter the distance from AIT that you live in kilometers & press enter: ");
    dist = f.nextDouble();

    System.out.print("Enter your age & press enter: ");
    age = f.nextInt();

    System.out.print("Enter your height & press enter: ");
    height = f.nextDouble();

    System.out.print("Enter your weight & press enter: ");
    weight = f.nextDouble();



    //all the outputs of the information collected
    System.out.println("Your name: "+name+" Town: "+town);
    System.out.println(town+" is "+dist+" away from AIT.");
    System.out.println("You are "+height+" meters tall & "+weight+" kgs & you are a "+country+" citizen.");
    System.out.println("Your studying "+course+" for "+years+" years at AIT.");
    System.out.println("Your student number is "+sNum+" & your student email address is         "+sNum+"@student.ait.ie");
    System.out.println("Please review the information.");

    }
    }