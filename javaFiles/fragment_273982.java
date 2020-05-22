ArrayList<String> al = new ArrayList<String>();
        al.add("Raj");
        al.add("Sameer");
        al.add("Nitu");
        al.add("Biren");
        al.add("Vishal");
        ListIterator<String> it = al.listIterator();
        System.out.println("Forward direction:-");
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
        System.out.println("\nBackward direction:-");
        while(it.hasPrevious())
        {
            System.out.println(it.previous());
        }