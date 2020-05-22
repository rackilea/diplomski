LiftCard l = new LiftCard(cardnumber, cardtype);
        if (u != null) {
            if (u.getLiftCard() != null) {
                JOptionPane.showMessageDialog(this,
                        "Brukeren har allerede kort!");
            } else
                cardA.regLiftCard(l); //etc