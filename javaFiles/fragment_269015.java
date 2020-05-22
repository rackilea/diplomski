import java.util.List;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

public class Test {
    public static void main(String[] args) {
        Splitter splitter = Splitter.on('\t');
        String line = "\t\t\t";
        List<String> bits = Lists.newArrayList(splitter.split(line));
        System.out.println(bits.size()); // Prints 4
    }
}