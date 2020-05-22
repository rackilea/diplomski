int no=101;
    int no1;
try
        {
           dbStatement = con.createStatement();
           dbResult= dbStatement.executeQuery("select payslip_no from tbl_add_payroll ORDER BY  payslip_no  DESC LIMIT 1");

          if(dbResult.next()==false)
          {
               jTextField3.setText(String.valueOf(no));

          }
         else
          {         
            dbResult= dbStatement.executeQuery("select payslip_no from tbl_add_payroll ORDER BY payslip_no DESC LIMIT 1");      
                    while(dbResult.next())

                           {
                           deptno=dbResult.getInt("payslip_no");

                             }


                             no1=deptno+1;
                             jTextField3.setText(String.valueOf(no1));
          }


     }catch(Exception E)
     {

     }