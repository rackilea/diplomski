for (Cube cube : mBatchedCubes){
    cube.updateCameraDistance(camera);
}
mBatchedCubes.sort();
int index = 0;
for (Cube cube : mBatchedCubes){
    cube.setIndex(index++);
}