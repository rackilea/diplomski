public abstract class Plot {
    protected void doStuff(){
        //Implement general stuff for Plot
    };

    abstract void doSpecificStuff();
}

public class StandardPlot extends Plot {

    @Override
    public void doSpecificStuff() {
        // Make sure we still handle the base functionality (code reuse)
        doStuff(); //if needed. You can call standardPlot.doStuff() and then
                   //standardPlot.doSpecificStuff();

        // Make sure we also do stuff specific to the Estate plot type
    }

    public void extendedFunctionality() {
        // Do stuff that only applies to this plot type
    }
}