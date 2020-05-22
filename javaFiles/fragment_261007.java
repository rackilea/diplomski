boolean hc(Graph g){
    if(!g.hp()) return false;

    Vertex test = new Vertex();

    for(Vertex v : g){
        g.connect(test,v); //adds single edge between test and v
        if(!g.hp()) return false;
        g.disconnect(test,v); //removes any edges between test and v
    }

    //every test yielded a new graph with a Hamiltonian Path, therefore
    //g must have a Hamiltonian Cycle:
    return true;
}