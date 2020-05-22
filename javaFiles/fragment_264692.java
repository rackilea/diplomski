Scanner user_input = new Scanner(System.in);
int birth_year;

System.out.print("Enter your the year you were born: ");
birth_year = user_input.nextInt();

int age, current_year = 2016;
age = current_year - birth_year;

System.out.println("Your age is "+age)