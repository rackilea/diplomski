String[] menuOptions = { option1, option2, etc.};
for(int i = 0; i < menuOptions.length - 1; i++)
    System.out.println((i+1) + ". " + menuOptions[i]);

System.out.println("What option would you like to change?");

int temp = k.nextInt();

System.out.println("What would you like that option to become?");

menuOptions[temp-1] = k.nextLine();