Clipboard clipboard = Clipboard.getSystemClipboard(); 
  // add listner to your tableview selecteditemproperty   
userTable.getSelectionModel().selectedItemProperty().addListener( new ChangeListener() {
              // this method will be called whenever user selected row
            @override
             public void chnaged(ObservableValue observale, Object oldValue,Object newValue) {
               UserClass selectedUser = (UserClass)newValue;
             ClipboardContent content = new ClipboardContent();
                 // make sure you override toString in UserClass
             content.putString(selectedUser.toString()); 
             clipboard.setContent(content); 
            }
            });