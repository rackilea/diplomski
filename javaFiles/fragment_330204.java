public class MainActivity extends ... implements ...{
    Stack<View> pressedButtons = new Stack<>();
    ...
    @Override
    public void onClick(View view) {
        // If it is a number, not a backspace key - remember that we pressed it
        if(view.getId() != R.id.backspace) {  
            pressedButtons.push(view);
            txt.setText(txt.getText().toString() + ((Button) view).getText());
            view.setVisibility(View.INVISIBLE);
        }
        else {  // backspace key
            String text = txt.getText().toString();
            if(text.isEmpty())
                return;  // do this to prevent crash
            txt.setText(text.substring(0, text.length() - 1));
            // make the button visible again
            View lastPressedButton = pressedButtons.pop();
            lastPressedButton.setVisibility(View.VISIBLE);
        }
    }                
}