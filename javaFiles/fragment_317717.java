...
// In your view 
private void initTabPane(){
    AbstractModel socialModel = new SocialModel();

    // Pass the View
    AbstractController socialController = new MainController(socialModel, this); 
    ...
}


// In your controller
private AbstractView view;

public MainController(AbstractModel model, AbstracView view) {   
     ...
     this.view = view;
}

public Validate() {
    if (!model.isValid) {
        view.showError();
    }
    else {
        // do your stuff with the valid model 
    }
}