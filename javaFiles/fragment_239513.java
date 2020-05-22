Object selection = JOptionPane.showInputDialog(null,
        "Choose a contact type", "Contact Type",
        JOptionPane.INFORMATION_MESSAGE, null,
        ContactType.values(), ContactType.values()[0]);

  // check that selection is not null before using
  System.out.println(selection);