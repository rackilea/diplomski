public class DefaultListener implements ActionListener{

    @override
    public void actionPerformed(ActionEvent event){
        Object source = event.getSource();
        if(source instanceof ImageButton){
            (ImageButton)source.action();
        }
    }

}