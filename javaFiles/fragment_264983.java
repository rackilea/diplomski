public abstract class ProcessStrategy{
    public void process(){
        // Common code goes here
    }

}

public class ProcessOnFile extends ProcessStrategy{

    public void process(){
        super();
        // Class specific code goes here
    }
}

public class ProcessOnFileNetwork extends ProcessStrategy{

    public void process(){
        super();
        // Class specific code goes here
    }
}