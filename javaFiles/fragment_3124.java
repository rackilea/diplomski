myJList.addListSelectionListener(new ListSelectionListener() {

    @Override
    public void valueChanged(ListSelectionEvent e) {
        System.out.println("Hello you selected me!  "
            + dataList.getSelectedValue().toString());
    }
});