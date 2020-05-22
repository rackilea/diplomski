public class A {

    private void setupLayout() {

        ...
        button.addClickListener(new ActionListener() {
            public void actionPerfored(ActionEvent e)
            {
                handleClick();   
            }
        });
    }

}