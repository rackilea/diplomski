int a;

// a is uninitialized

if(r.nextInt(10) < 2)
   a = 5;

// a has an 80% chance of still being uninitialized

System.out.println(a); // error: a might not be initialized.