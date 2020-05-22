import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ObjectCalculator {
    static int compute(int[][] array){
        return Arrays.stream(array)
                .map(ObjectCalculator::findObjects)
                .mapToInt(objects -> {
                    int min, max;
                    if (objects.size() < 2) min = 0;
                    else min = Collections.min(objects);
                    if (objects.size() < 1) max = 0;
                    else max = Collections.max(objects);
                    return max - min;
                }).sum();
    }

    static List<Integer> findObjects(int[] array) {
        ArrayList<Integer> objects = new ArrayList<>();
        int curSize = 0;
        for(int i : array){
            if(i == 1)curSize++;
            else if(curSize > 0){
                objects.add(curSize);
                curSize = 0;
            }
        }
        if(curSize > 0){
            objects.add(curSize);
        }
        return objects;
    }
}