FileChooserWindow.get_stage().focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> ov, Boolean oldValue, Boolean newValue) {
                if (!newValue){
                    if(AutogenPopup.popupReturner().focusedProperty().get()){
                        AutogenPopup.popupReturner().hide();
                    }
                }else{
                    if(FileChooserController.refreshAutoPopup && FileChooserController.autoGen_flag){
                        AutogenPopup.popupReturner().show(FileChooserWindow.get_stage());
                    }
                }
            }

        });