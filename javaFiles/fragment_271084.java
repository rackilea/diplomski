import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.tuple.Pair;
import com.google.common.collect.Lists;

public class TwoDimArray {

    public static Integer keyCalculator(Pair<Integer, Integer> point) {
        return point.getLeft() * point.getRight();
    }

     public static Map<Integer, Integer> myMethod(List<Pair<Integer, Integer>> points) {
        return points.stream()
                     .collect(Collectors.toMap(p -> keyCalculator(p), p -> p.getRight()));

    }

    public static void main(String[] args) {
        Pair<Integer, Integer> pointA = Pair.of(1, 2);
        Pair<Integer, Integer> pointB = Pair.of(3, 4);
        Pair<Integer, Integer> pointC = Pair.of(5, 6);
        List<Pair<Integer, Integer>> points = Lists.newArrayList(pointA, pointB, pointC);
        System.out.println("Points map: " + myMethod(points));

    }

}