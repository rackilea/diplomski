// in /release

class MyThing() {

  void doStuff() { /* nothing */ }
}


// in /debug

class MyThing() {

  void doStuff() { 
    actual();
    code();
  }
}