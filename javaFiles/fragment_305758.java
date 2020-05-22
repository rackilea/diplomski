import com.google.inject.ImplementedBy;

@ImplementedBy(Testingimpl.class)
public interface Testing {
    public String tt();
}