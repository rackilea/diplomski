for (int i = 0; i< 20; i++) {
    ToggleButton tb = new ToggleButton("ToggleButton"+i);
    tb.setUserData("UserData"+i);
    tb.setOnAction(e -> {
        System.out.println(tb.getText() + " - Selected: " + tb.isSelected() 
            + "; UserData: " + tb.getUserData());
    });
}