FormElement form = (FormElement) document.select(form#formulaire).first();
List<Connection.KeyVal> formData = form.formData();
System.out.println(formData.get(4).value()); //printing the value of  KeyVal #4 
form.formData().get(4).value("value changed");//changing its value
System.out.println(form.formData().get(4).value());//printing again its value which must be different

Result: 
Old value
value changed