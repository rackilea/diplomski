ListIterator litr = al.listIterator();

   A   B   C
 ^
  System.out.print(litr.next());  // print A and move to next

   A   B   C
     ^
  System.out.print(litr.next());  // print B and move to next

   A   B   C
         ^
  System.out.print(litr.next());  // print C and move to next

   A   B   C
             ^
  System.out.print(litr.previous());  // print previous which is C and move backward

   A   B   C
         ^
  System.out.print(litr.previous());  // print previous which is B and move backward

   A   B   C
     ^
  System.out.print(litr.next());      // print B and move to next

   A   B   C
         ^
  System.out.print(litr.previous());  // print previous which is B and move backward

   A   B   C
     ^