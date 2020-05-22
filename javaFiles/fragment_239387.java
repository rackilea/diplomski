@Override
protected Object doEvaluation(ILocation location, Object[] underlyingMeasures) throws QuartetException {
    double[] asArray = (double[]) underlyingMeasures[0];

    if (asArray == null) {
        return null;
    } else {
        // Size of the array
        int size = asArray.length;

        // Allocate a Pointer to provide the double[] to the C++ DLL
        Pointer<Double> pCount = allocateDoubles(size);

        pCount.setDoubles(asArray);

        CPP_Collateral.multiply(2D, size, pCount);

        // Read again: the double[] is copied back in the heap
        return pCount.getDoubles();
    }
}