public interface LogCodeProvider {
    String getLogCode();
}

public class CaseOutlineHeader implements LogCodeProvider {
    @Override
    public String getLogCode() {
        return "My Code";
    }
}