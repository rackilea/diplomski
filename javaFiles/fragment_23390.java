for (int i = 0; i <= circleVertexCount; i++) {
    double angle = i * theta / circleVertexCount;
    x = (float) Math.cos(angle) * r;
    y = (float) Math.sin(angle) * r;
    vertexData[i * 2] = x + offSetX;
    vertexData[i * 2 + 1] = y + offSetY;
}