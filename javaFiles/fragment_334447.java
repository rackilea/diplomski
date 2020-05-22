// this is a new instance variable in `A`
private volatile boolean cancelled = false;

// this is part of your methodA
for (int n=0;n<100;n++) {
  if ( cancelled ) {
    return; // or handle this however you want
  }    
}

// each of your other loops should work the same way