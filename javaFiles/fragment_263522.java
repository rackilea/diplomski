if (button.getTag().equals("blue")){ //background is currently blue
    changeBackgroundColorRed();
    button.setTag("red"); //set the Tag to red cause you change the background to red
}
else if (button.getTag().equals("red")){ //background is currently red
    changeBackgroundColorBlue();
    button.setTag("blue"); //set the Tag to blue cause you change the background to blue
}