final int floatsPerVertex = 5; // 3 spatial +  2 texture
float[] meshData = new float[numVerticies * floatsPerVertex];
for (int i = 0; i < numVerticies; i++) {
   meshData[(i * floatsPerVertex) + 0] = ... ; // x coordinate of i'th vertex
   meshData[(i * floatsPerVertex) + 1] = ... ; // y coordinate of i'th vertex
   meshData[(i * floatsPerVertex) + 2] = ... ; // z coordinate of i'th vertex
   meshData[(i * floatsPerVertex) + 3] = ... ; // u texture coordinate of i'th vertex
   meshData[(i * floatsPerVertex) + 4] = ... ; // v texture coordinate of i'th vertex
}
myMesh.setVertices(meshData);