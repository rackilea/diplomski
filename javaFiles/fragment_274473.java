public static final MeshData mergeLazy(List<MeshData> meshes, List<Matrix4f> transformations) {

    ArrayList<Float> vertices = new ArrayList<>();
    ArrayList<Float> texCoords = new ArrayList<>();
    ArrayList<Float> normals = new ArrayList<>();
    ArrayList<Integer> indices = new ArrayList<>();
    int offset = 0;
    int m = 0;

    for(MeshData mesh : meshes) {

        Matrix4f transformation = transformations.get(m);
        float[] mVertices = mesh.getVertices();
        float[] mNormals = mesh.getNormals();

        for(int index = 0; index < mesh.getVertices().length; index += 3) {

            Vector3f vertex = MatrixUtil.multiply(transformation, mVertices[index], mVertices[index + 1], mVertices[index + 2]);
            vertices.add(vertex.x);
            vertices.add(vertex.y);
            vertices.add(vertex.z);

            Vector3f normal = MatrixUtil.multiply(transformation, mNormals[index], mNormals[index + 1], mNormals[index + 2]);
            normals.add(normal.x);
            normals.add(normal.y);
            normals.add(normal.z);
        }

        ListUtil.addFloatArray(texCoords, mesh.getTextureCoordinates());
        int[] mIndices = mesh.getIndices();

        for(int index : mIndices) {

            indices.add(index + offset);
        }

        offset += mVertices.length / 3;
        m++;
    }

    MeshData mesh = new MeshData();
    mesh.setIndices(ListUtil.toPrimitiveIntArray(indices));
    mesh.setNormals(ListUtil.toPrimitiveFloatArray(normals));
    mesh.setTextureCoordinates(ListUtil.toPrimitiveFloatArray(texCoords));
    mesh.setVertices(ListUtil.toPrimitiveFloatArray(vertices));

    return mesh;
}