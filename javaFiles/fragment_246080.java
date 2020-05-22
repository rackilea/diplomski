void refreshMyPanel(){
    Control[] oldControls = my_group.getChildren();

    for (Control oldControl : oldControls)
        oldControl.dispose();

    for(int i = 0; i < 6; i++){
        Label label = new Label(linear_img_group, SWT.NONE);

        Image image = new Image(Display.getDefault(), linear_list.get(i));

        label.setImage(image);

        label.addListener(SWT.Dispose, new Listener()
        {
            @Override
            public void handleEvent(Event e)
            {
                Label thisLabel = (Label) e.widget;
                Image thisImage = thisLabel.getImage();
                if(!thisImage.isDisposed();
                    thisImage.dispose();
            }
        });

        label1_lin.setBounds(x0, y0, xSize, ySize);
    }
}