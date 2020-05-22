public static void main(String[] args) throws Exception {

    Scanner input = new Scanner(System.in);
    System.out.print("How many people are you entering? ");
    int people = input.nextInt();
    Human[] person = new Human[people];

    for (int i = 0; i < people; i++) {

        System.out.println("Creating new human number : " + i);
        Human h = new Human();
        person[i] = h;

        System.out.print("Please enter an age: ");
        person[i].age = input.nextInt();
        System.out.print("Please enter a name: ");
        person[i].name = input.next();
        System.out.print("Please enter a gender: ");
        person[i].gender = input.next();

    }

    System.out.println("Here are the people that you entered: ");

    for (int i = 0; i < person.length; i++) {
        System.out.print(person[i].age + " ");
        System.out.print(person[i].name + " ");
        System.out.println(person[i].gender);
    }

    input.close();

}