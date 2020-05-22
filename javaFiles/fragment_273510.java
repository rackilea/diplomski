public boolean hasCycle(int start)
{
    vertexList[start].wasVisited = true;
    for (int j = 0; j < MAX_VERTS; j++) {  
        if (adjMat[start][j] == 1  &&  (vertexList[j].wasVisited  ||  hasCycle(j)))
            return true;
    }
    return false;
}