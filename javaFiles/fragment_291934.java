import com.sun.jna.Native;

public class JNA_PSAPI_Test_optimized {

    public static native boolean GetPerformanceInfo(PerformanceInformationStruct pPerformanceInformation, int cb);

    static {
        Native.register("psapi");
    }

    public static void main(String[] args) throws InterruptedException {
        PerformanceInformationStruct tPerfInfo = new PerformanceInformationStruct();

        while (true){
            GetPerformanceInfo(tPerfInfo, 104);
            System.out.println("nonPagedPool (MB): "+tPerfInfo.KernelNonpaged * tPerfInfo.PageSize / Math.pow(1024,2));
            Thread.sleep(1000);
        }
    }
}