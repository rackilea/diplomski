for (int i = 2; i < 400; i += 2) {
    double angle = theta * i / circleVertexCount;
    x = (float) Math.cos(angle) * r;
    vertexData[i] = x + offSetX;
}

for (int i = 3; i < 404; i += 2) {
    double angle = Math.PI * 2 * i / circleVertexCount;
    y = (float) Math.sin(angle) * r;
    vertexData[i] = y + offSetY;
}