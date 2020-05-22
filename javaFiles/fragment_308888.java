Scanner Required = new Scanner(System.in);
System.out.println("Enter the number of required matches: ");
int RequiredMatches = Target.nextInt();

int Number = (int) (1 + 10 * Math.random());
int sum = 1;
if (NumberTarget > 10) { 
  System.out.println("Error"); 
} else {
    while ((Number != NumberTarget) || (RequiredMatches > 0)) { 
        System.out.println("Your number is " + Number);
        Number = (int) (1 + 10 * Math.random());
        ++sum;
        if (Number==NumberTarget) {
            RequiredMatches--;
        }
        System.out.println("You reached your target " + RequiredMatches + " times in " + sum + " tries.");
    }
}