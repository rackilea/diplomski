[...]
StayOpenPopup popup = new StayOpenPopup();
popup.add(panel);
[...]
button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        if(popup.isVisible())
            popup.disappear();
        else popup.show(button,0,button.getHeight());
    }
});