int o =JOptionPane.showOptionDialog(bcfiDownloadPanel,
        new Object[]{panel},
        "Authorization Required",
        JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.INFORMATION_MESSAGE,
        null,
        new WebButton[]{new WebButton("OK"), new WebButton("Cancel")}, // this is the array
        "default"