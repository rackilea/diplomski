public class Customer {  
    private int accountId;  

    public Customer() {  
        this.accountId = 0;  
    }  

    public Customer(int account_identification) {  
        this.accountId = account_identification);  
    }  

    //As a side note, general practice implies fields be private  
    //Use a method (hence the term 'getter' and the reciprocal, 'setter')  
    public int getId() {  
        return this.accountId;  
    }  

    public void setId(int replacement_account_identification) {  
        this.accountId = replacement_account_identification;  
    }
}