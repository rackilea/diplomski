Random r = new Random();
for (int rows=i; rows<M; rows++)
    for (int cols=j; cols<N; cols++) {
        bool found = false;
        while (!found)
            switch (r.next() % 4) {
                case 0: if(northValid) { DFS(iNorth,j); found = true; } break;
                case 1: if(southValid) { DFS(iSouth,j); found = true; } break;
                case 2: if(eastValid)  { DFS(i, jEast); found = true; } break;
                case 3: if(westValid)  { DFS(i, jWest); found = true; } break;
            }
    }