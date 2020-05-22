public class ButtonClicksCounter {
    static ArrayList<JButton> _buttonsClicked = new ArrayList<JButton>();
    public static void addButton(JButton btn) {
        _buttonsClicked.add(btn);
    }

    public static int getButtonClicksCount() {
        return _buttonsClicked.size();
    }

    public static void clearButtonClicksCount() {
        _buttonsClicked.clear();
    }

    public ArrayList<JButton> getButtonsClicked() {
        return _buttonsClicked;
    }

}

public class ButtonSwapHandler implements ActionListener{


JButton _button;
Model _model;
UI _ui;

public ButtonSwapHandler(UI u, Model m, JButton b1){
    _model=m;
    _button=b1;
    _ui =u;
}

@Override
public void actionPerformed(ActionEvent e) {
   //Add the button
   ButtonClicksCounter.addButton((JButton)e.getSource());

   //Check if count==2
   if(ButtonClicksCounter.getButtonClicksCount()==2) {
      ArrayList<JButton> buttonsToSwap = ButtonClicksCounter.getButtonsClicked();

      //Get positions
      int i = _ui.getTiles().indexOf(buttonsToSwap[0]);
      int j = _ui.getTiles().indexOf(buttonsToSwap[1]);

      //Swap
      _model.swap(ui._tile,i,j);

      //Clear selection
      ButtonClicksCounter.clearButtonClicksCount();
   }

}