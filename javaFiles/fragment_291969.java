int numdigits = Integer.parseInt (scanner.nextLine ());
    // for the dot
    if (numdigits > 1) 
        ++numdigits;
    int i;

    while ((i = reader.read ()) != -1 && count != numdigits) {
         System.out.print ((char) i);
         count++;
   }