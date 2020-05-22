interface MyAnonymous {
   MyAnonymous open();
   MyAnonymous dis();  //or even void here
}

new MyAnonymous(){
    public MyAnonymous open(){
        // do some stuff
        return this;
    }
    public MyAnonymous dis(){
        // do some stuff
        return this;
    }
}.open().dis();