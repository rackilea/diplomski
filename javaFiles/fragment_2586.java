final Formatter x;
    try{

        x = new Formatter(jTextField1.getText() + ".txt");

    } catch(Exception e) {
        System.out.println("Something went horribly wrong..");
    }
}