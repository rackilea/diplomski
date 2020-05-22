@PostMapping(value="addChild")
public String addChild(@RequestParam("first_name") String firstName,
                       @RequestParam("second_name") String secondName,
                       @RequestParam ("sex") String sex,
                       @RequestParam ("pesel") String pesel){

        ChildForm childForm = new ChildForm();
        childForm.setFirstName(firstName);
        childForm.setSecondName(secondName);
        childForm.setSex(sex);
        childForm.setPesel(pesel);
        childService.addChildToDB(childForm);

        return "AddChild";
}

@PostMapping(value="createFamily")
public String createFamily(){
       return 'basic';    
}