public class GUI extends JFrame {
    MyInternalFrame1 iFrame1 = new MyInternalFrame1();

    ....
    // somewhere else in code
    DataModel dataModel = iFrame1.getDataModel();
    dataModel.setData("Hello");
    new MyInternalFrame2(dataModel);
}