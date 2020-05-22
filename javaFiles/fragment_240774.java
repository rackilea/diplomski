int width = 5;
int height = 5;
int length = 5;
int numCubes = width*height*length;

ModelBuilder mb = new ModelBuilder();
mb.begin();
MeshPartBuilder mpb = mb.part("cubes", GL20.GL_TRIANGLES, (Usage.Position | Usage.Normal), new Material(ColorAttribute.createDiffuse(Color.GREEN)));
for (int i=0; i<numCubes; i++){
    mpb.box(1, 1, 1); 
}
Model model = mb.end();
mBatchedCubesModelInstance = new ModelInstance(model);