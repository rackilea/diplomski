mBatchedCubes.get(0).rotate(1, 1, 1, 180*delta); //example manipulation of a single cube

for (Cube cube : mBatchedCubes){ //must update any changed cubes. 
    cube.update(mBatchedCubesVertices);
}
mBatchedCubesMesh.setVertices(mBatchedCubesVertices); //apply changes to mesh

...

modelBatch.begin(camera);
modelBatch.render(mBatchedCubesModelInstance);
modelBatch.end();