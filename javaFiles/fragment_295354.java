class PhoneBookTest
{
  public static void main( String[] args )
  {
    List<PhoneBook> phoneBooks = new ArrayList<PhoneBook>( 5 );
    Scanner input = new Scanner (System.in);

    System.out.println ("Welcome to your Phone Book");
    System.out.println ("Add Entries to the list");
    System.out.println ();

    for (int i = 1; i < = phoneBooks.size(); i++)
    {
        System.out.println ("Enter Name: ");
        String name = input.nextLine();
        System.out.println();
        System.out.println ("Enter Number: ");
        String number = input.nextLine();
        System.out.println();

        PhoneBook newEntry = new PhoneBook( name, number );
        phoneBooks.add( newEntry );
    }
  }
}