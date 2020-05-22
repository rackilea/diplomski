Image image = new Image();
        image.addLoadHandler(new LoadHandler() {

            @Override
            public void onLoad(LoadEvent event) {
                // resize image
                image.getElement().getStyle().setVisibility(Style.Visibility.Visible); 
            } 


        });

image.getElement().getStyle().setVisibility(Style.Visibility.HIDDEN); 
RootPanel.get().add(image);
image.setUrl(url);