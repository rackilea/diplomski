package lambdademo;

import org.openjdk.jmh.annotations.*;

import java.util.List;

@State(Scope.Benchmark)
public class LambdaBenchmark {
    @Param("100")
    private static int loopCount;

    private static double identity(double val) {
        double result = 0;
        for (int i=0; i < loopCount; i++) {
            result += Math.sqrt(Math.abs(Math.pow(val, 2)));    
        }
        return result / loopCount;
    }

    private List<EmployeeRec> employeeList = new EmployeeFile().loadEmployeeList();

    @Benchmark
    public double streamAverage() {
        return streamAverageNoInline();
    }

    @Benchmark
    @Fork(jvmArgs = "-XX:-Inline")
    public double streamAverageNoInline() {
        return employeeList.stream()
                .filter(s -> s.getGender().equals("M"))
                .mapToDouble(s -> s.getAge())
                .average()
                .getAsDouble();
    }

    @Benchmark
    public double streamMath() {
        return streamMathNoIntrinsic();
    }

    @Benchmark
    @Fork(jvmArgs = {"-XX:+UnlockDiagnosticVMOptions", "-XX:DisableIntrinsic=_dpow,_dabs,_dsqrt"})
    public double streamMathNoIntrinsic() {
        return employeeList.stream()
                .filter(s -> s.getGender().equals("M"))
                .mapToDouble(s -> identity(s.getAge()))
                .average()
                .getAsDouble();
    }
}