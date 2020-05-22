example code:

new WizardPage1(sharedObject)

new WizardPage2(sharedObject)

WizardPage1:

checkBtn.addListener(SWT.Selection, new Listener(){

public void handleEvent(Event e){

   sharedObject.setCheck(true);

}

});