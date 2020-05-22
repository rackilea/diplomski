@Create
public void initialize() throws MissingMyEntityException {

    if(qualifiedCustomer == null){
        throw new MissingMyEntityException("something wrong");
    }
    ....
}