private Model createPlaneModel(final float width, final float height, final Material material, 
            final float u1, final float v1, final float u2, final float v2) {

modelBuilder.begin();
MeshPartBuilder bPartBuilder = modelBuilder.part("rect", 
GL10.GL_TRIANGLES, Usage.Position | Usage.Normal | Usage.TextureCoordinates, 
material);
//NOTE ON TEXTURE REGION, MAY FILL OTHER REGIONS, USE GET region.getU() and so on
bPartBuilder.setUVRange(u1, v1, u2, v2);
        bPartBuilder.rect(
                -(width*0.5f), -(height*0.5f), 0, 
                (width*0.5f), -(height*0.5f), 0, 
                (width*0.5f), (height*0.5f), 0, 
                -(width*0.5f), (height*0.5f), 0,
                0, 0, -1);


        return (modelBuilder.end());
    }