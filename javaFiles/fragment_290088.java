class MyHandler implements EventHandler<Event> {

    private String button = "";

    public MyHandler(String s) {
        this.button = s;
    }

    @Override
    public void handle(Event t) {
        if(button.equals("Yes")) {
            // do yes
            System.out.println("Yes");
        }
        else {
            // do no
            System.out.println("No");
        }
    }

}