// ...
for(int x = 0; x < terrain.terrainSizeX-1; x++) {
    GL11.glTexCoord2f(x, z);
    GL11.glVertex3f(x*size, terrain.terrain[x][z], z*size);
    GL11.glTexCoord2f(x, z + 1);
    GL11.glVertex3f(x*size, terrain.terrain[x][z+1], (z+1)*size);
}
// ...