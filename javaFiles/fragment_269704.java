Shell shell = ...

JTouchBar jTouchBar = new JTouchBar();
jTouchBar.setCustomizationIdentifier("MySWTJavaTouchBar");

// flexible space
jTouchBar.addItem(new TouchBarItem(TouchBarItem.NSTouchBarItemIdentifierFlexibleSpace));

// button
TouchBarButton touchBarButtonImg = new TouchBarButton();
touchBarButtonImg.setTitle("Button 1");
touchBarButtonImg.setAction(new TouchBarViewAction() {
    @Override
    public void onCall( TouchBarView view ) {
        System.out.println("Clicked Button_1.");
    }
});

Image image = new Image();
img.setName(ImageName.NSImageNameTouchBarColorPickerFill);
touchBarButtonImg.setImage(image);

jTouchBar.addItem(new TouchBarItem("Button_1", touchBarButtonImg, true));

// label
TouchBarTextField touchBarTextField = new TouchBarTextField();
touchBarTextField.setStringValue("TextField 1");

jTouchBar.addItem(new TouchBarItem("TextField_1", touchBarTextField, true));

// enable touchbar
jTouchBar.enableForShell(shell);