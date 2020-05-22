public class BasicCommand implements Command, Callable<Integer>{

private int operationId;

public BasicCommand(int operationId) {
    this.operationId = operationId;
}

public Integer call(){
    this.execute();
    return operationId;
}

@Override
public void execute() {
    //Log.d("BasicCommand", "Id: " + operationId);
    System.out.println("hello executing command" + operationId);
}

public static void main(String[] args) throws Exception {


    ExecutorService exceutorService= Executors.newSingleThreadExecutor();
    exceutorService.submit(new BasicCommand(1));
    Future future =exceutorService.submit(new BasicCommand(2));
    System.out.println("result:" +future.get());

}