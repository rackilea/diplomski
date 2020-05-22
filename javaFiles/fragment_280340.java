// case 1 - abc
  if(lessThan(a,b) && lessThan(b,c)) {
     System.out.println(a + " " + b + " " + c);
  }
  // case 2 - acb
  else if(lessThan(a,c) && lessThan(c,b)) {
     System.out.println(a + " " + c + " " + b);
  }
  // case 3 - bac
  else if(lessThan(b,a) && lessThan(a,c)) {
     System.out.println(b + " " + a + " " + c);
  }