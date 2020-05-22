ArrayList<Vector3> vertices = new ArrayList<>();

landscape.calculateTransforms();
    Renderable rend = new Renderable();
    Mesh mesh = landscape.getRenderable(rend).meshPart.mesh;

    int vertexSize = mesh.getVertexSize() / 4;
    float[] verts = new float[mesh.getNumVertices() * vertexSize];
    short[] inds = new short[mesh.getNumIndices()];
    mesh.getVertices(verts);
    mesh.getIndices(inds);

    for (int i = 0; i < inds.length; i++) {
        int i1 = inds[i] * vertexSize;
        Vector3 v = new Vector3(verts[i1], verts[i1 + 1], verts[i1 + 2]);

        v.set(v.prj(rend.worldTransform));


        vertices.add(v);
    }

    Vector3 dir = new Vector3(0, 10, 0);
    Vector3 pos = new Vector3(random.nextFloat(),random.nextFloat(),random.nextFloat());
    Ray ray = new Ray(pos, dir.cpy());

        for (int i = 0; i < vertices.size() - 3; i+=3){
            if (Intersector.intersectRayTriangle(ray, vertices.get(i), vertices.get(i + 1), vertices.get(i + 2), pos)) {
                //pos now contains the correct coordinates
                break;
            }