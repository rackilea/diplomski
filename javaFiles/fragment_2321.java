public class AssyliasDistanceCalculator implements DistanceCalculator {
    public Integer computeSpeed(Integer distance, Integer time) {  
        return distance / time;
    }
}

public class BobDistanceCalculator implements DistanceCalculator {
    public Integer computeSpeed(Integer distance, Integer time) {
        return distance / time * 2;
    }
}