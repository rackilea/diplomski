public static String check_payment_status(String id)
{
    String remaining_amount = null;
    try {
        ResultSet courseid=dbcon().executeQuery("select course_id from student where student_id='"+id+"'");   
        while(courseid.next()){
            String idcrs=courseid.getString("course_id");
            ResultSet rsfee=dbcon().executeQuery("select fee from course where course_id='"+idcrs+"'");    
            while(rsfee.next()){
                int fee=rsfee.getInt("fee");
                ResultSet payments=dbcon().executeQuery("select amount from payment where student_id='"+id+"'");
                int pmnt[]=new int[30];
                int add=0;
                for(int i=0;payments.next();i++){
                    pmnt[i]=payments.getInt("amount");        
                    add+=pmnt[i];        
                }
                int rem_amout_pay = fee - add;
                return Integer.toString(rem_amout_pay);    
            }                
        }
    } catch (Exception e) {
    } 
    return remaining_amount;
}