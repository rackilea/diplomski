if (o == sendButton || o == inputBox)
    {
        if (inputBox == null)
        {
            System.out.println("NULL");
        }

        if(inputBox.getText() != "")
        {
            //out.println(inputBox.getText());
            //out.flush();

            try
            {
                bw.write(inputBox.getText());
                bw.flush();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            inputBox.setText("");
        }
    }