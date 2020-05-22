class SumService {

    private float calculateSum(Iterable<Integer> i) {
        float total = 0.0f;
        for (Integer x : i) {
            total += x;
        }
        return total;
    }

}