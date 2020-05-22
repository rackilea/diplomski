@Override
            protected void updateItem(AnchorPane anchorPane, boolean empty){
                super.updateItem(anchorPane, empty);
                if(anchorPane != null){
                    if(anchorPane.getId.equals("headerBottomPane")){
                        setItem(anchorPane); //moved at the top
                        setMouseTransparent(true); //added this line
                        setFocusTraversable(false); //added this line
                        setDisable(true);
                }else{
                    setItem(null);
                }
            }