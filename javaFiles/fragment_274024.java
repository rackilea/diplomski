float radius = 1.0f;
for (int i = 0; i <= 360; i++) {
    gl.glBegin(GL2.GL_LINE_LOOP);
    float theta = i * (Math.PI / 180.0f);
    for (int j = 0; j <= 180; j++) {
        float phi = j * (Math.PI / 180.0f);
        float x = radius * Math.sin(phi) * Math.cos(theta);
        float y = radius * Math.sin(phi) * Math.sin(theta);
        float z = radius * Math.cos(phi);
        gl.glVertex3f(x, y, z);
    }
    gl.glEnd();
}