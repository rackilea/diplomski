String initialValue = "Purchase";
String cashOut = "Cashout";
String[] options = new String[]{initialValue, cashOut};

NotifyDescriptor nd = new NotifyDescriptor(
            popupSelector,
            "Title",
            NotifyDescriptor.YES_NO_OPTION,
            NotifyDescriptor.QUESTION_MESSAGE,
            options,
            initialValue
    );

String selectedValue = (String) DialogDisplayer.getDefault().notify(nd);
if (selectedValue.equals(initialValue)) {
    // handle Purchase
} else if (selectedValue.equals(cashOut)) {
    // handle Cashout   
} else {
    // dialog closed with top close button
}