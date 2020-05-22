private void generateMesh(float xshift_mesh, float yshift_mesh, float zshift_mesh, float size_mesh) {
    if(size_mesh < 0) {
        return; 
    }
    float size = size_mesh/2; 
    mesh = new Mesh(true, 4, 6, VertexAttribute.Position(), VertexAttribute.ColorUnpacked(), VertexAttribute.TexCoords(0), VertexAttribute.Normal());
    mesh.setVertices(new float[] 
      //<------------ Position XYZ ------------------------>   <-Color RGBA->   <Texture Coordinates UV>   <Normal XYZ>
      //|               -,                  -,           -,|   |-, -, -, -, |   | -, -, |                  |-, -, -|
    {   
        -size+xshift_mesh,  -size+yshift_mesh, zshift_mesh,     1, 1, 1, 1,       0, 1,                     0, 0, 1,
         size+xshift_mesh,  -size+yshift_mesh, zshift_mesh,     1, 1, 1, 1,       1, 1,                     0, 0, 1,
         size+xshift_mesh,   size+yshift_mesh, zshift_mesh,     1, 1, 1, 1,       1, 0,                     0, 0, -1,
        -size+xshift_mesh,   size+yshift_mesh, zshift_mesh,     1, 1, 1, 1,       0, 0,                     0, 0, -1
    });
    mesh.setIndices(new short[] {0, 1, 2,2, 3, 0});
}