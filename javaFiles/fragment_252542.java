import java.util.Arrays;
import java.util.List;

public class ApiCallerExample {
    public static void main(String[] args) {
        ApiCaller a = new ApiCaller();

        List<Runnable> commands = Arrays.asList(
            a::endpointB, 
            a::endpointA, 
            a::endpointD,
            a::endpointC, 
            a::endpointA, 
            a::endpointB);
        commands.forEach(Runnable::run); // Prints "BADCAB"
    }
}

class ApiCaller { 
    public void endpointA () { System.out.print("A"); }
    public void endpointB () { System.out.print("B"); }
    public void endpointC () { System.out.print("C"); }
    public void endpointD () { System.out.print("D"); }
}