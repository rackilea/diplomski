public abstract class Report<T extends Report<T>> implements Iterable<ReportItem<T>>{

    private List<ReportItem<T>> itemList;

    public void add(ReportItem<T> item){
        itemList.add(item);
    }

    //Some other stuff

}

public class ConcreteReport extends Report<ConcreteReport> { 
    //Some stuff
}