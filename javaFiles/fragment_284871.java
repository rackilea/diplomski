class PhoneNumber { 

     private final String val;

     public PhoneNumber(final String val){
         this.val = val;
     }

     @Override
     public int hashCode(){
         return this.getVal().hashCode();
     }

     @Override
     public boolean equals(Object obj){
         if (this == obj) {
           return true;
         }
         if (obj == null) {
           return false;
         }
         if (this.getClass() != obj.getClass()) {
           return false;
         }

         PhoneNumber other = (PhoneNumber )obj;
         return PhoneNumberUtils.compare(this.getVal(), other.getVal()) == 0;
     }

     public String getVal(){
        return this.val;
     }
} 

private Set<PhoneNumber> getCommonPhoneNumbers(List<String> dbPhoneNumbers , List<String> userPhoneNumbers){
    Set<PhoneNumber> common = new HashSet<PhoneNumber>();

    Set<PhoneNumber> phoneNumbers = new HashSet<PhoneNumber>();
    for(String s : userPhoneNumbers){
        phoneNumbers.add(new PhoneNumber(s));
    }

    for(String s : dbPhoneNumbers ){
        PhoneNumber phoneNo = new PhoneNumber(s);
        if(phoneNumbers.contains(phoneNo)){
            common.add(phoneNo);
        }
    }

    return common;
}