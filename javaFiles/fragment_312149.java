public void makeCall() {
    try {
        int gadgetDisplay = Integer.parseInt(displayText.getText());

        if (gadgetDisplay < 0) {
            JOptionPane.showMessageDialog(frame, "Please enter a positive Display");
        }
        else if ( gadgetDisplay >= yourList.size() ) {
            JOptionPane.showMessageDialog(frame, "Gadget is not listed");
        }
        else {
            Mobile phoneCall = (Mobile) gadgets.get(getDisplay());
            phoneCall.PhoneCall(getPhoneNumber(), getDuration());
            System.out.println();
        }
    }
    catch(NumberFormatException exception) {
        JOptionPane.showMessageDialog(frame, "Please enter a positive Display");
    }
}