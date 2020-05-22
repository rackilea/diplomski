private static void makeThingsWork() {
    int n_points = faces.length * 3;
    short count = 0;
    int j = 0;

    float[] fixedvertices = new float[n_points];
    float[] fixednormals = new float[n_points];
    short[] fixedfaces = new short[faces.length];

    for(int i = 0; i < n_points; i+=3)
    {
        j = i/3;
        fixedvertices[i] = vertices[faces[j]*3];
        fixedvertices[i+1] = vertices[faces[j]*3 + 1];
        fixedvertices[i+2] = vertices[faces[j]*3 + 2];

        fixednormals[i] = normals[normalIndices[j]*3];
        fixednormals[i+1] = normals[normalIndices[j]*3 + 1];
        fixednormals[i+2] = normals[normalIndices[j]*3 + 2];

        fixedfaces[i/3] = count;
        count++;
    }

    vertices = fixedvertices;
    normals = fixednormals;
    faces = fixedfaces;


}