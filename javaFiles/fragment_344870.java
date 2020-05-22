import com.bedatadriven.spss.SpssDataFileReader;
import com.bedatadriven.spss.SpssVariable;

public class SPSSDemo {

    public static void main(String[] args) {
        try {
            SpssDataFileReader reader = new SpssDataFileReader(args[0]);

            for (SpssVariable var : reader.getVariables()) {
                System.out.println(var.getVariableName());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}