public class ClassToRun implements Job {

@Override
public void execute(JobExecutionContext context) throws JobExecutionException {
    try{
        //doSomething
    }
    catch(Exception e){
        e.printStackTrace(System.out);
    }
  }
}