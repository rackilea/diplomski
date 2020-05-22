class Presenter implements IObserver
{
    public void aMethod() { }

    public void notifyObserver() { }
}

class Model
{
    private List<IObserver> observers = new ArrayList<>();

    public void addObserver(IObserver obs) { observers.add(obs); }

    public void notifyObservers()
    {
        for(IObserver o : observers) { o.notifyObserver(); }
    }
}


final Presenter myPresenter = new Presenter();
Model myModel = new Model();
myModel.add(myPresenter);

new Thread(new Runnable() 
{
    @Override
    public void run()
    {
        while(true)
        {
            myPresenter.aMethod();
        }           
    }
).start();