while( (s= br.readLine()) != null ) {
    String [] numbers = s.split(" ");     // split the line 
    int a = Integer.parseInt(numbers[0]); // take only the first one
    ....

    System.out.print(st);
    System.out.println("\t");
    l.clear();  // clear the list before trying to find primes for the new line
}