public class DisplayRecords {
 public static void main(String[] args){

        RetriveRecords rr = new RetriveRecords();
        ArrayList a = rr.listMethod();
        Iterator i = a.iterator();

       while(i.hasNext()){

              Employee e =(Employee) i.next();
              System.out.println(e.getEno());
              System.out.println(e.getName());
}
}
}