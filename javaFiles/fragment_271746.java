public static void main(String[] args) {

    // latitude/longitude/age in milliseconds/signal strength
    final PositionInfo[] data = new PositionInfo[]{
            new PositionInfo(43.48932915, 1.66561772, 1000, -20),
            new PositionInfo(43.48849093, 1.6648176, 2000, -10),
            new PositionInfo(43.48818612, 1.66615113, 3000, -50)
    };


    double[] target = new double[data.length];
    Arrays.fill(target, 0.0);

    double[] start = new double[2];

    for (PositionInfo row : data) {
        start[0] += row.latitude;
        start[1] += row.longitude;
    }
    start[0] /= data.length;
    start[1] /= data.length;

    MultivariateJacobianFunction distancesModel = new MultivariateJacobianFunction() {
        @Override
        public Pair<RealVector, RealMatrix> value(final RealVector point) {
            double tgtLat = point.getEntry(0);
            double tgtLong = point.getEntry(1);

            RealVector value = new ArrayRealVector(data.length);
            RealMatrix jacobian = new Array2DRowRealMatrix(data.length, 2);
            for (int i = 0; i < data.length; i++) {
                DerivativeStructure distance = getWeightedEuclideanDistance(tgtLat, tgtLong, data[i]);
                //DerivativeStructure distance = getWeightedHaversineDistance(tgtLat, tgtLong, data[i]);
                value.setEntry(i, distance.getValue());
                jacobian.setEntry(i, 0, distance.getPartialDerivative(1, 0));
                jacobian.setEntry(i, 1, distance.getPartialDerivative(0, 1));
            }

            return new Pair<RealVector, RealMatrix>(value, jacobian);
        }
    };


    LeastSquaresProblem problem = new LeastSquaresBuilder()
            .start(start)
            .model(distancesModel)
            .target(target)
            .lazyEvaluation(false)
            .maxEvaluations(1000)
            .maxIterations(1000)
            .build();

    LeastSquaresOptimizer optimizer = new LevenbergMarquardtOptimizer().
            withCostRelativeTolerance(1.0e-12).
            withParameterRelativeTolerance(1.0e-12);

    LeastSquaresOptimizer.Optimum optimum = optimizer.optimize(problem);
    RealVector point = optimum.getPoint();
    System.out.println("Start = " + Arrays.toString(start));
    System.out.println("Solve = " + point);
}