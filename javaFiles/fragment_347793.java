if ((a >= b) && (a >= c) && (a >= d) && (a >= e)) { // a >= b,c,d,e
    System.out.println ("Largest is: " + a);
} else if ((b >= c) && (b >= d) && (b >= e)) {      // b >= c,d,e
    System.out.println ("Largest is: " + b);
} else if ((c >= d) && (c >= e)) {                  // c >= d,e
    System.out.println ("Largest is: " + c);
} else if (d >= e) {                                // d >= e
    System.out.println ("Largest is: " + d);
} else {                                            // e > d
    System.out.println ("Largest is: " + e);
}