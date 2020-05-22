RadioChoice radioChoice = new RadioChoice("myRadio", choiceList);
radioChoice.add( new AjaxFormChoiceComponentUpdatingBehavior("onchange") { 
    protected void onUpdate(AjaxRequestTarget target) {
        // Ajax actions here
        System.out.println("The selected value is " + getComponent().getDefaultModelObjectAsString()));
    }
}  );
form.add(radioChoice);