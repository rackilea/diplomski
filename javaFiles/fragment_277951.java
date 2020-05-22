modalDialog.setWindowClosedCallback(new ModalWindow.WindowClosedCallback() 
   { 
           private static final long serialVersionUID = 1L; 

           @Override 
           public void onClose(AjaxRequestTarget target) 
           { 
               target.addComponent(getPage()); 
           } 
   });