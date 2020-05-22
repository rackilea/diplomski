import java.util.*;
import com.mathworks.toolbox.javabuilder.*;  // MATLAB Java Builder
import Epidemic.*;                           // our compiled package

public class TestEpidemic {
    public double[] getArray() throws MWException {
        Epidemic obj = null;
        Object[] out = null;
        double [] arr = null;
        try {
            obj = new Epidemic();
            out = obj.epidemic(1);  // request one output
            arr = (double[]) ((MWArray)out[0]).getData();
        } catch (MWException e) {
            System.out.println("Exception: " + e.toString());
        } finally {
            MWArray.disposeArray(out);
            obj.dispose();
        }
        return arr;
    }

    public static void main (String[] args) {
        try {
            TestEpidemic e = new TestEpidemic();
            double[] arr = e.getArray();
            for(double x : arr) {
                System.out.println(x);
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}