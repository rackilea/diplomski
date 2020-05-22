class Program {
    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();

        // populate 'points'

        PointStatistics statistics = points
                    .stream()
                    .collect(PointStatistics::new, PointStatistics::accept, PointStatistics::combine);
    }
}