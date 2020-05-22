public void addRotatedSphere_ByMessingWithMesh(){
    Sphere sphere1Mesh = new Sphere(50, 50, 2);
    sphere1Mesh.setTextureMode(Sphere.TextureMode.Projected); // matrc


    FloatBuffer textureBuffer=sphere1Mesh.getFloatBuffer(Type.TexCoord);

    float[] newTextureCoordinates=new float[textureBuffer.capacity()];


    for(int i=0;i<newTextureCoordinates.length;i++){
        //texture buffer goes x co-ordinate, y coordinate, x coordinate, y coordinate
        if (i%2!=1){
            newTextureCoordinates[i]=(float)((textureBuffer.get(i)+0.5)%1);
        }else{
            newTextureCoordinates[i]=textureBuffer.get(i);
        }
    }

    sphere1Mesh.setBuffer(Type.TexCoord, 2,newTextureCoordinates);

    Material sphere1Mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
    sphere1Mat.setTexture("ColorMap", assetManager.loadTexture("Textures/world.png"));



    Geometry sphere1Geo = new Geometry("Rotated Sphere", sphere1Mesh);
    sphere1Geo.setMaterial(sphere1Mat); 
    sphere1Geo.setLocalTranslation(0, 2, 0);



    rootNode.attachChild(sphere1Geo);
}