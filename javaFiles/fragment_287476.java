public class MyTask extends BaseTask {
    public ABC(ParamA aParam, String name) {
        super(aParam);
        this.name = name == null ? "Default Value" : name;
    }
    @Override
    public void run() {
         System.out.println("Name length: "+ name.length());
    }
}