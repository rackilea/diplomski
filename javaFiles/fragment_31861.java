public MeshView createCuboid(float w, float h, float d) {
    float hw = w / 2f;
    float hh = h / 2f;
    float hd = d / 2f;

    float points[] = {
             hw,  hh,  hd,
             hw,  hh, -hd,
             hw, -hh,  hd,
             hw, -hh, -hd,
            -hw,  hh,  hd,
            -hw,  hh, -hd,
            -hw, -hh,  hd,
            -hw, -hh, -hd};

    float L = 2 * w + 2 * d;
    float H = h + 2 * d;

    float tex[] = {
                  d / L,          0f,
            (d + w) / L,          0f,
                     0f,       d / H,
                  d / L,       d / H,
            (d + w) / L,       d / H,
        (2 * d + w) / L,       d / H,
                     1f,       d / H,
                     0f, (d + h) / H,
                  d / L, (d + h) / H,
            (d + w) / L, (d + h) / H,
         (2 *d + w) / L, (d + h) / H,
                     1f, (d + h) / H,
                  d / L,          1f,
            (d + w) / L,          1f};

    float normals[] = {
         1f,  0f,  0f,
        -1f,  0f,  0f,
         0f,  1f,  0f,
         0f, -1f,  0f,
         0f,  0f,  1f,
         0f,  0f, -1f,
    };

    int faces[] = {
            0, 0, 10, 2, 0,  5, 1, 0,  9,  
            2, 0,  5, 3, 0,  4, 1, 0,  9,  
            4, 1,  7, 5, 1,  8, 6, 1,  2,   
            6, 1,  2, 5, 1,  8, 7, 1,  3,  
            0, 2, 13, 1, 2,  9, 4, 2, 12,  
            4, 2, 12, 1, 2,  9, 5, 2,  8,  
            2, 3,  1, 6, 3,  0, 3, 3,  4,  
            3, 3,  4, 6, 3,  0, 7, 3,  3,  
            0, 4, 10, 4, 4, 11, 2, 4,  5,  
            2, 4,  5, 4, 4, 11, 6, 4,  6,  
            1, 5,  9, 3, 5,  4, 5, 5,  8,  
            5, 5,  8, 3, 5,  4, 7, 5,  3}; 

    TriangleMesh mesh = new TriangleMesh();
    mesh.setVertexFormat(VertexFormat.POINT_NORMAL_TEXCOORD);
    mesh.getPoints().addAll(points);
    mesh.getTexCoords().addAll(tex);
    mesh.getNormals().addAll(normals);
    mesh.getFaces().addAll(faces);

    return new MeshView(mesh);
}