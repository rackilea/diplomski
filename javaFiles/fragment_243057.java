import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test2 extends BaseTset {

    @Test(dataProvider = "dataprovider")
    public void test(DataReader2 reader) {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Test : " + reader.getValue("Key_" + i));
        }
    }

    @DataProvider(name = "dataprovider")
    public DataReader2[] dataProvider() {
        String dataFileName = "TestData.xlsx";
        DataReader2 reader = new DataReader2(dataFileName);
        int rowCount = reader.getRowCount();
        DataReader2[] reader2 = new DataReader2[rowCount];
        for (int i = 0; i < rowCount; i++) {
            int j = i + 1;
            reader2[i] = DataReader2.getReader(dataFileName, j);
        }
        return reader2;
    }
}