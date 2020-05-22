for (Personnel person: staff)
    {
        if (person.getPayNum() == searchQuery)
        {
            System.out.print("\n------------- Staff member found! -------------");
            System.out.println("\n\nFirst Name(s): " + person.getFirstNames());
            System.out.println("Surname: " + person.getSurname());
            return;
        }
    }
    System.out.print("\n------------- No staff members found -------------");