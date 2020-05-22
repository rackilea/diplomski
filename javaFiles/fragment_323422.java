System.out.println("Please enter ID of contact: ");
String soughtId = input.nextLine();

for (Contact showcontact: contacts)
{
   if (showcontact.getContactId().equals(soughtId))
           System.out.println(showcontact.displayContact());
}