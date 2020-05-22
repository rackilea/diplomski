User.UserBuilder builder = new User.UserBuilder("Jhon", "Doe");

    // First thread
    Thread t1 = new Thread(){
    @Override
    public void run()
    {
        builder.age(30).build();         
    }};

    // Second thread
    Thread t2 = new Thread(){
        @Override
        public void run()
        {
            // Just changing age temporarily in builder.
            builder.age(140);
            builder.age(35).build();         
        }};

   t1.start();
   t2.start();