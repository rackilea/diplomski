public void makeCall() {
    try {
        Mobile phoneCall = (Mobile) gadgets.get(getDisplay());
        phoneCall.PhoneCall(getPhoneNumber(), getDuration());
        System.out.println();
    }
    catch(NumberFormatException exception) {
        JOptionPane.showMessageDialog(frame, "Please enter a positive Display");
    }
    catch(IndexOutOfBoundsException exception) {
        JOptionPane.showMessageDialog(frame, "Gadget is not listed");
    }
    catch(IllegalArgumentException exception) {
        JOptionPane.showMessageDialog(frame, "Please enter a positive Display");
    }
}

public int getDisplay() throws NumberFormatException
{
    int gadgetDisplay = Integer.parseInt(displayText.getText());

    if (gadgetDisplay < 0) {
        throw new IllegalArgumentException("Please enter a positive Display");  
    }
    else if ( gadgetDisplay >= yourList.size() ) {
        throw new IndexOutOfBoundsException("Gadget is not listed");
    }

    return gadgetDisplay;
}