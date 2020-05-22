import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Foo {

    @SerializedName("positive")
    @Expose
    private List<String> positive = null;
    @SerializedName("medical")
    @Expose
    private List<String> medical = null;

    public List<String> getPositive() {
        return positive;
    }

    public List<String> getMedical() {
        return medical;
    }

}