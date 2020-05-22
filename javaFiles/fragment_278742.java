public class MainClass implements Observer
{
    public static void main(String[] args) 
    {
        ReadFile rf = new ReadFile();

        MainClass mainClass = new MainClass();

        rf.addObserver(mainClass);

        rf.readFile();
    }

    @Override
    public void update(Observable o, Object arg)
    {
        // This method will be called after the File is finished reading.
    }
}