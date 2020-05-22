public  class MyTextField extends TextField{


    public MyTextField(){
    }

    public String getStr(){
        return this.getValue();
    }
}


public class MyButton extends Button{

    public MyButton(final MyTextField text){
    setCaption("UPDATE");
    addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                System.out.println(text.getStr());
            }
       });
    }
}
//And in your presentation logic 

    final MyTextField text = new MyTextField();
    MyButton button = new MyButton(text);
    mainLayout.addComponent(text);
    mainLayout.addComponent(button);