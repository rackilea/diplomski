Version version = null; // superclass reference
if (input == 1){
    version = new Version1(); // instance of subclass Version1
}
else{
    version = new Version2(); // instance of subclass Version2
}
// Now you can use the object version.