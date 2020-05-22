public class MaxLengthTextFormatter extends TextFormatter<String> {
    private int maxLength;

public MaxLengthTextFormatter(int maxLength) {
    super(new UnaryOperator<TextFormatter.Change>() {
        @Override
        public TextFormatter.Change apply(TextFormatter.Change change) {
            //If the user is deleting the text (i.e. full selection, ignore max to allow the
            //change to happen)
            if(change.isDeleted()) {
                //if the user is pasting in, then the change could be longer
                //ensure it stops at max length of the field
                if(change.getControlNewText().length() > maxLength){
                    change.setText(change.getText().substring(0, maxLength));
                }

            }else if (change.getControlText().length() + change.getText().length() >= maxLength) {
                int maxPos = maxLength - change.getControlText().length();
                change.setText(change.getText().substring(0, maxPos));
            }
            return change;
        }
    });
    this.maxLength = maxLength;
}

public int getMaxLength()
{
    return maxLength;
}