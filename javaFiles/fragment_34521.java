String number;

Bus(int n) {
    this( String.valueof(n) ); // or do other thing, as you need
}

Bus(String n) {
    number = n;
}