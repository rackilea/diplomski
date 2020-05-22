mBatchedCubesMesh = model.meshes.get(0);
    VertexAttributes vertexAttributes = mBatchedCubesMesh.getVertexAttributes();
    int vertexFloatSize = vertexAttributes .vertexSize / 4; //4 bytes per float
    mBatchedCubesVertices = new float[numCubes * 24 * vertexFloatSize]; //24 unique vertices per cube
    mBatchedCubesMesh.getVertices(mBatchedCubesVertices);

    mBatchedCubes = new Array<Cube>(numCubes);
    int cubeNum = 0;
    for (int x = 0; x < width; x++) {
        for (int y = 0; y < height; y++) {
            for (int z = 0; z < length; z++) {
                mBatchedCubes.add(new Cube((x-(width/2f))*1.5f, -((y-(height/2f)) * 1.5f), -(z-(length/2f))*1.5f, 1,1,1, cubeNum++, vertexAttributes, mBatchedCubesVertices ));
            }
        }
    }