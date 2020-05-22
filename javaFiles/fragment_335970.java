//to convert row on Paymentmode table into column name of syncbill table
    String q1 = "select concat('OTHERPAYMENT',p) as op from Paymentmode where IsActive=Y"; 
    rs = stmt.executeQuery(q1); 
    String str = ""; 
    while(rs.next()) {   
    str += rs.getString(1) + ","; 
    }
//to get desired result
    String q2 = "select Paytm, Cash," + str.substring(0, str.length()-1) +" from syncbill";

// below this execute q2