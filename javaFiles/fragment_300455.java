squareMesh = new Mesh(true, 4, 4, 
            new VertexAttribute(Usage.Position, 3, "a_position")
            ,new VertexAttribute(Usage.TextureCoordinates, 2, "a_texCoords")

    );

    squareMesh.setVertices(new float[] {
            squareXInitial, squareYInitial, squareZInitial,             0,1,    //lower left
            squareXInitial+squareSize, squareYInitial, squareZInitial,  1,1,    //lower right
            squareXInitial, squareYInitial+squareSize, squareZInitial,  0,0,    //upper left
            squareXInitial+squareSize, squareYInitial+squareSize, squareZInitial,1,0});  //upper right 

    squareMesh.setIndices(new short[] { 0, 1, 2, 3});