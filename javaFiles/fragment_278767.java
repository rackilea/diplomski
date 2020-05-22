import java.util.*;

public class ImageMatrix {
    private int[] data;
    private int classCode;

public ImageMatrix(int[] data, int classCode) {
    assert data.length == 64;
    this.data = data;
    this.classCode = classCode;
}

    public String toString() {
        return "Class Code: " + classCode + " DataSet:" + Arrays.toString(data) + "\n";
    }

    public int[] getData() {
        return data;
    }

    public int getClassCode() {
        return classCode;
    }

}