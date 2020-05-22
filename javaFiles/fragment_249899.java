public class DataModel {
    private String data;

    public DataModel() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }    
}

public class MyInternalFrame1 extends JInternalFrame {
    private DataModel dataModel = new DataModel();

    public DataModel getDataModel() {
        return dataModel;
    }

}

public class MyInternalFrame2 extends JInternalFrame {
    private DataModel dataModel;

    public MyInternaFrame1() {}

    public MyIntenalFrame2(DataModel datModel) {
        this.dataModel = dataModel;
    }

    public void setDataModel(DataModel dataModel) {
        this.dataModel = dataModel;
    }
}