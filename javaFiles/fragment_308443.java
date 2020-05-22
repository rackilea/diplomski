public class UserMB {

    private Long personalId; //Not sure what your actual type is 

    @Column(unique = true)//Uniqueness constraint
    public Long getPersonalId() { 
        return personalId; 
    }

    //Remainder omitted
}