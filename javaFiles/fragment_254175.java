public void init(){
    char x='\n';
    Choice c = new Choice();
    c.add("1");
    c.add("2");
    c.add("3");
    c.addItemListener(new CustomItemListener());
    add(c);
}

class CustomItemListener implements ItemListener
{
    @Override
    public void itemStateChanged(ItemEvent e)
    {
        //Your code to do something - ie
        if(e.getSource() == c) {
            if(c.getSelectedItem().equals("1")) {
                System.out.println("1 is selected in Choice selector c");
                // or to launch a class
                new YourClassYouWantToLauch();
            }
        }
    }
}