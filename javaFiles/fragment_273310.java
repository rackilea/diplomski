Character character;
int chosen;
Scanner sc = new Scanner(System.in);
System.out.println("Pick one character by number either 1 or 2");
int input = sc.nextInt();

switch (input) {

    case 1:
        character = new Spiderman();
        System.out.println("You picked Spiderman");
    case 2:
        character = new Venom();
        System.out.println("You picked Venom");
    }

character.fight();
character.block();