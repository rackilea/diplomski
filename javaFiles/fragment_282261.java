while(i.hasNext())
      {
         Strng s = i.next(); // note this
         if(al.contains("B"))
        {
            i.remove();
            System.out.println(" Element B removed");
        }
        System.out.println(s);

    }