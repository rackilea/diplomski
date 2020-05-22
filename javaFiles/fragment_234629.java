try
        {
            //convert number to double (monetary value)
            bidAmount = Double.parseDouble(messageToServer);
            if(bidAmount < 0){
                throw new IllegalArgumentException("Invalid amount");
            }
            //send to server with item code
            output.println(selectedItemCode + bidAmount);
        }
        //item cannot turned to double
        catch (IllegalArgumentException numfEx)
        {
            //inform user
            fromServer.setText("Invalid Request!"
                    + USER_PROMPT);
        }