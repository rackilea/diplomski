public void itemStateChanged(ItemEvent ie) {
                if(ViewSpace.getState()){
                    tx.setText(tx.getText().replace(" ","."));

            }
                else
                {
                    String last = tx.getText().substring(tx.getText().length()-1, tx.getText().length());
                    String rest = tx.getText().substring(0, tx.getText().length()-1);
                    if(!last.equals("."))
                    tx.setText(tx.getText().replace("."," "));
                    else
                        {
                        rest=rest.replace("."," ");
                        tx.setText(rest+".");

                        }
                }