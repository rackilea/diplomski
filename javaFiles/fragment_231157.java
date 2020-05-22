public class StudentRecord {
   Student stu;
   Address addr;

   public StudentRecord() {
      Student stu;
      Address addr;
   }

   public StudentRecord(String _fName, String _lName, int _id, double _gpa, String _street, String _city, String _state, int _zip){
        this.stu = new Student(_fName, _lName, _id, _gpa);
        this.addr=new Address(_street,_city,_state,_zip);
   }

   public String toString() {
      return String.format(stu + "\n" + addr);
   }
}