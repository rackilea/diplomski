public boolean hasCycle(int start, int parent)
{
    vertexList[start].wasVisited = true;
    for (int j = 0; j < MAX_VERTS; j++) {  
        if (j != parent  &&  adjMat[start][j] == 1  &&  (vertexList[j].wasVisited  ||  hasCycle(j, start)))
            return true;
    }
    return false;
}