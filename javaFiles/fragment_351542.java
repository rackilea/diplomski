public class HugeTaskRunner extends AbstractTaskRunner {

public HugeTaskRunner(Object[] params, CallBack callBack) {
    super(params, callBack);
    // TODO Auto-generated constructor stub
}

@Override
public void doTask() {
    // HERE YOU'LL HAVE TO DO SOME HUGE TASK ACTIONS
    // THEN YOU'LL NEED TO CALL callBack.doCall(params) to update GUI 
    String newText = "Image #1 has been loaded";
    params[params.length -1] = newText; // assuming that the last param is for updated text
    callBack.doCall(params);

}

}