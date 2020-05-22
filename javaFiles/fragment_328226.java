public class SomePanel extends JPanel{

private ActionListener myAction = new ActionListener(){
       @Override
       public void actionPerformed(ActionEvent evt){
           value =1;//or what you want
       }

}; 

public ActionListener getMyAction{
    return myAction;
}


}