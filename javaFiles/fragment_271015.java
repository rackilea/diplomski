System.out.println("\nTitle of the student (eg, Mr, Ms): ");
String title = keyboard.next();

while (!title.equals("Mr") && !title.equals("Ms") && !title.equals("mr") && !title.equals("ms")) {
{
  System.out.println("Attention! Title must be Mr or Ms please choose one.");

  System.out.println("\nTitle of the student (eg, Mr, Ms): ");
  title = keyboard.next();
}

list[i].setTitle(title);