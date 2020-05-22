Zwierzak z = new Zwierzak();
    session.save(z);

   !!!Consider a flush here !!!
   session.flush();

            //Creating choroba
    Choroba ch = new Choroba();
            //Setting parent in child class
    ch.setZwierzak(z);
            //Adding child in parent class
    z.getChoroby().add(ch);
            //Saving child
    session.save(ch);