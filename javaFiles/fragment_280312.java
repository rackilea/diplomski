public buttons {

    JButton button; 
    JButton button1 = new JButton();
    JButton button2 = new JButton();

    ArrayList<JButton> buttonList;

    public buttons() {
        button = new JButton();
        button1 = new JButton();
        button2 = new JButton();
        buttonList = new ArrayList<JButton>();
        //...
        buttonList.add(button);
        buttonList.add(button1);
        buttonList.add(button2);
    }

    public static void main(String args[]){

    }
}