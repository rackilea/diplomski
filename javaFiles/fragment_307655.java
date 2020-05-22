int patchWidth = (int)Math.ceil((double)imageW / pSize);
    int patchHeight = (int)Math.ceil((double)imageH / pSize);

    IntStream.range(0, patchWidth * patchHeight).parallel().forEach(i -> {
        int x = (i % patchWidth);
        int y = (i / patchWidth);

        thisPatch = MatrixUtil.getSubMatrixAsMatrix(image, x * pSize, y * pSize, pSize);
        results[x][y] = computeParamForPatch(thisPatch);
    });