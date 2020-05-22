public void valueChanged(ListSelectionEvent e) {

    if (!e.getValueIsAdjusting()) {
        Vector masterVec = masterVector.get( list.getSelectedIndex() );

        System.out.print("id : ");
        System.out.println(masterVec.get(0));

        System.out.print("front text : ");
        System.out.println(masterVec.get(1));

        System.out.print("reverse text : ");
        System.out.println(masterVec.get(2));

        frontTextField.setText(masterVec.get(1).toString());
        reverseTextArea.setText(masterVec.get(2).toString());;
    }
}