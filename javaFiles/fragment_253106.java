public class Example implements Runnable {
    private dataObject args;

    public Example(dataObject input) {
        args = input;
    }
    public void dosort(dataObject sortArg){contents}

    public void run() {
        dosort(args);
    }
}

public static void main(stuff) { 
    Example myExample = new Example(data);
    //alternate example
    //myExample.setData(data);
    new Thread(myExample).start();
}