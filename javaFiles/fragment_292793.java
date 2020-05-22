DropDownChoice<String> clinicNames =
    new DropDownChoice<String>("clinicNames",
                               new PropertyModel<String>(this, "selectedName"),
                               polNames) {
        // @Override
        // public void onSelectionChanged() {
        //     // Generate and submit your query here
        // }
    };

// EDIT: onSelectionChanged() is a final method; use this instead
OnChangeAjaxBehavior clinicNamesListener = new OnChangeAjaxBehavior() {
    protected void onUpdate(AjaxRequestTarget target) {
        // Generate and submit your query here
    }
};
clinicNames.add(clinicNamesListener);