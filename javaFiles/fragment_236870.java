modelBuilder.begin();
modelBuilder.part("box", GL20.GL_TRIANGLES, 
        VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal | VertexAttributes.Usage.TextureCoordinates,
        new Material(TextureAttribute.createDiffuse(AssetLoader.tr[0])))
    .box(2f, 2f, 2f);
box = modelBuilder.end();