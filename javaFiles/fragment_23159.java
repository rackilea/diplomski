public static void main(String [] args)
{
    Scanner scan = new Scanner(System.in);
    int age = 1;
    System.out.print("Enter your dog's age in human years: (or a negative number to exit)");
    for(;age>=0;){
       age = scan.nextInt();
       int dogAge = age * 7;
       System.out.println("Your dog is "+age+" in human years and "+dogAge+" in dog years!");
       if(dogAge>=150)System.out.println("Likely story");
       else if (dogAge>=80 && dogAge<150) System.out.println("Hello grand-dog");
       else if(dogAge>=40 && dogAge<80)System.out.println("Boring!");
       else if(dogAge>=20 && dogAge<40)System.out.println("Get a job!");
       else if(dogAge<20)System.out.println("Just a pup!");
    }
}