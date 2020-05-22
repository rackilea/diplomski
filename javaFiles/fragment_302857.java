autocompleteCombo.valueProperty().addListener(new ChangeListener() {

    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        Member member = (Member) list.get(newValue);
        System.out.println(member.getId());
        System.out.println(member.getMilkNo());
        System.out.println(member.getFullName());
    }
});