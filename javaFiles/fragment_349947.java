boolean finished = false;
String name = null;  // initialized to a default value.

System.out.println("Enter 'Q' to quit");
while(!finished) {
System.out.println("Enter name: ");
name = read.readLine();  // moved declaration outside of loop
if(name.equals("Q")) { 
   finished = true;
 }
  // do work with name
}