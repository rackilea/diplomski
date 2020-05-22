public Person(Scanner file)
{
    this.name = file.nextLine();
    this.location = file.nextLine();
    this.age = file.nextInt();
    file.nextLine(); // Make sure you're pointing at the new line!
}