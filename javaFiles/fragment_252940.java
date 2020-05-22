// After the loop
while (count != 0)
{
   System.out.print("Enter Cost");
   cost = conIn.nextFloat();
   sb.place(count, cost);

   System.out.print("Enter count (use 0 to stop): ");
   count = conIn.nextInt();
}
System.out.print(sb);

// After you placed the object in the bag,
// If you want the user to know what he has after each insertation
while (count != 0)
{
   System.out.print("Enter Cost");
   cost = conIn.nextFloat();
   sb.place(count, cost);

   System.out.print(sb);
   System.out.print("Enter count (use 0 to stop): ");
   count = conIn.nextInt();
}