interface Validator {
     // since it is not clear what are the attributes that matter for a record, 
     // this takes an instance of Record. 
     // Modify to accept relevant attribures of Record
     public boolean validate (Record r);
 }

 class ConcreteValidator implements Validator {
      // implements a validation logic
 }

// implements Comparable so that it can be used in rules that compare Records
abstract class Record implements Comparable<Record> {
    protected Validator v;
    abstract void setValidator(Validator v);
    public boolean isValid() {
        return v.validate(this);
    }
}

class ConcreteRecord extends Record {
   // alternatively accept a Validaor during the construction itself 
   // by providing a constructor that accepts a type of Validator
   // i.e. ConcreteRecord(Validator v) ...
    void setValidator(Validator v) {
        this.v = v;
    }

    // implementation of method from Comparable Interface
    public int compareTo(final Record o) {... }
}

public class Test {
    public static void main(String[] args) {
        // Store the read in Records in a List (allows duplicates)
        List<Record> recordList = new ArrayList<Record>();
        // this is simplistic. Your Record creation mode might be 
        // more complex, And you can use a Factory Method 
        // (or Simple Factory) for creation of  ConcreteRecord
        Record r = new ConcreteRecord();
        r.setValidtor(new ConcretedValidator());
        if (r.isValid()) {
            // store only valid records
            recordList.add(r);
        }

       // do further processing of Records stored in recordList
    }

}