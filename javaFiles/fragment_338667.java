public class ThreadEjecucionLambda extends Thread {

    Runnable funcion;

    public ThreadEjecucionLambda(Runnable funcion)
    {
        super(funcion);
        this.funcion = funcion;
    }
    public void run()
    {
        super.start();
    }
}