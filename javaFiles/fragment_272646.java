bool hasAdjacent = False;
for(i=0; i<G.numVertex; i++){
    if(G.adj[i][startVertex] != false){
        hasAdjacent = True;
        ...

    }
}
if (!hasAdjacent) {
    int c = pilha.pop();
    visited.add(c);
}