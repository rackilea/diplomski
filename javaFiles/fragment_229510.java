@NotEmpty.List({
    @NotEmpty( message = "Person name should not be empty",   
               groups=PersonValidations.class),
    @NotEmpty( message = "Company name should not be empty",    
               groups=CompanyValidations.class),
})
private String name;