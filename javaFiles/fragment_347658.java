String question = "Is your favorite color Red?";
textArea.setText(question);
if(textArea.getText().equals(question))
{
        if (text.replaceAll("'", "").toLowerCase().contains("yes")){
            textArea.setText("Cool!");
        }else if (text.replaceAll("'", "").toLowerCase().equals("no")){
            textArea.setText(":(");
        }
}