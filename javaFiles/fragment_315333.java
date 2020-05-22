public class ServiceHelper{
    @Transational(proparation = **Propagation.REQUIRED_NEW**)
    public void tryConstraint throws MyConstraintException{
        try{
           //insert
        }catch(ConstraintViolationException e){
           throw new MyConstraintException(e);
        }catch(Exception ex){
           throw new Exception(ex);
        }
    }

    @Transational(proparation = **Propagation.REQUIRED_NEW**)
    public void insertWithNoConflict throws Exception {
        //Set new data
        //insert, if still CVE or anything other, just throw it , or leave it for unchecked exceptions then
    }


}