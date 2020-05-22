public boolean verify(JComponent input) {
        String name = input.getName();

        if (name.equals("FnTF")) {
            // your code
            }
        } else if (name.equals("LnTF")) {
            // your code

        }
        //enable dependent components
        for (JComponent r : component) {
            r.setEnabled(true);
        }
        /* And Now we are here */
        fNamePicLbl.setVisible(true); 
        lNamePicLbl.setVisible(true);
         // making visible two of them at once as soon as verify is called 
            // on any one of the components, verifier is registered

        return true;
    }