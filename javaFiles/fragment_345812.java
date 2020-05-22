String displaySecret = wordField.getText();
if(displaySecret=NULL){/*case for fist execution*/
    displaySecret="";
    for (int i = 0; i < random.length(); i++)
    displaySecret += "*";
}