public EmpDetails() {

    formData = new FormData("-20");

    empVP = new VerticalPanel(); 
    empVP.setStyleName("topPanel"); 
    empVP.setSpacing(10); 
    createForm();
    empVP.setHorizontalAlign(HorizontalAlignment.CENTER);

    add(empVP);
}