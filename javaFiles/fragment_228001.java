StringBuilder str = new StringBuilder(b);
   System.out.println("string = " + str);

   // insert character at offset 8
   str.insert(8, 's');

   // print StringBuilder after insertion
   System.out.print("After insertion = ");
   System.out.println(str.toString());// this will print Tutorials