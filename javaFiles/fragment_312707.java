int o =JOptionPane.showOptionDialog(bcfiDownloadPanel,
            new Object[]{panel},
            "Authorization Required",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            new WebButton[]{this.ok, this.cancel}, // this is the array
            "default"