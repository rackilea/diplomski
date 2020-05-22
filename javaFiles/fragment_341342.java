@Component
public class Data {


    @Value("#{'${my.list}'.split(',')}")
    List<String> values;



    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

}