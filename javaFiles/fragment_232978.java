public class Test {
public static void main(String[] args) {
    String data = " Lead Details\n" +
            "Caller Name: Mr Rahul from Rajouri Garden\n" +
            "Caller Requirement: Money Exchangers\n" +
            "Caller Phone: +918459761134\n" +
            "Caller Email: rchand.rahul@gmail.com\n" +
            "Call Date & Time: Tue, 18 Jun 2013 14:40:38\n" +
            "Branch Info: Rajouri Garden\n" +
            "City: Delhi";

    String[] subStr=data.split("\n");

    for (String i:subStr){
        if(i.contains("Caller Name")){
            System.out.println("Caller Name: "+i.split(":")[1]);
        }if(i.contains("Caller Requirement")){
            System.out.println("Caller Requirement: "+i.split(":")[1]);
        }if(i.contains("Caller Phone")){
            System.out.println("Caller Phone: "+i.split(":")[1]);
        }if(i.contains("Caller Email")){
            System.out.println("Caller Email: "+i.split(":")[1]);
        }if(i.contains("Call Date & Time")){
            System.out.println("Call Date & Time: "+i.split(":")[1]);
        }if(i.contains("Branch Info")){
            System.out.println("Branch Info: "+i.split(":")[1]);
        }if(i.contains("City")){
            System.out.println("City: "+i.split(":")[1]);
        }
    }
}

}