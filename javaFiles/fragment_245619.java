public String addEntityX(@ModelAttribute final ExampleForm exampleForm, BindingResult result) {

    new EntityXValidator().validate(exampleForm, result);
    if (result.hasErrors()) {
        // ...
    }
    else{
        // ...
    }

    // ...
}