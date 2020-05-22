@AfterReturning(value="execution(public java.util.List *(..)) " 
       + "&& target(com.example.demoaop.repo.IBaseRepository) "
        ,returning="list")
public void decry(List list) throws Exception
{
    //Do some magic here
}