import java.util.Arrays;
import java.util.List;
import com.sun.jna.Structure;

public class PerformanceInformationStruct extends Structure {
    public int cb;
    public long CommitTotal;
    public long CommitLimit;
    public long CommitPeak;
    public long PhysicalTotal;
    public long PhysicalAvailable;
    public long SystemCache;
    public long KernelTotal;
    public long KernelPaged;
    public long KernelNonpaged;
    public long PageSize;
    public int HandleCount;
    public int ProcessCount;
    public int ThreadCount;
    public PerformanceInformationStruct() {
        super();
    }

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList(new String[]{"cb", "CommitTotal", "CommitLimit", "CommitPeak", "PhysicalTotal", "PhysicalAvailable", "SystemCache", "KernelTotal", "KernelPaged", "KernelNonpaged", "PageSize", "HandleCount", "ProcessCount", "ThreadCount"});
    }
}