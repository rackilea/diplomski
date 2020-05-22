float horizontalScaling = textState.getHorizontalScaling() / 100f;
[...]
Matrix parameters = new Matrix(
        fontSize * horizontalScaling, 0, // 0
        0, fontSize,                     // 0
        0, textState.getRise());         // 1
[...]
Matrix textRenderingMatrix = parameters.multiply(textMatrix).multiply(ctm);