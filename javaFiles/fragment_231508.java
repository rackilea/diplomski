LiftCard l = new LiftCard(cardnumber, cardtype);
        if (u != null) {
            if (u.getLiftCard() != null) {
                JOptionPane.showMessageDialog(this,
                        "Brukeren har allerede kort!");
            } else
                l.setUser(u); // <-- here we set the `User` on the `LiftCard`.
                cardA.regLiftCard(l); //etc