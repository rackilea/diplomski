if(iconSelected && !but.equals(selectedButton)){ // move(swap) buttons
        Icon bIcon = but.getIcon();
        but.setIcon(selectedButton.getIcon());
        selectedButton.setIcon(bIcon);
        ...
}