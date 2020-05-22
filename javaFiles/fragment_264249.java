if(d[u] == Double.POSITIVE_INFINITY){
        break;
    }

    for(int v=0; v<adj.length; v++){
        double tmp = d[u] + adj[u][v];
        if(tmp < d[v]){
            d[v] = tmp;
            pi[v] = u;
        }
    }