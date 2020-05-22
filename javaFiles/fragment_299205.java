matrixA.operateOnAll(ADD.second(scalarB)).supplyTo(matrixC);

    matrixC.fillMatching(matrixA, ADD, scalarB);

    matrixC.modifyAll(ADD.second(scalarB));

    matrixA.passMatching((from, i, j, to) -> {
        to.set(i, j, from.doubleValue(i, j) + scalarB);
    }, matrixC);