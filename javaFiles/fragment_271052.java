try{
             int num[]={1,2,3,4};
             System.out.println(num[5]);
        }catch(Exception e){        
        test.log(LogStatus.INFO/ERROR, ExceptionUtils.getStackTrace(e));
        }