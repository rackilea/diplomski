int nStations = ...;
int[][] travelTime = new int[nStations][nStations];
for (int i = 0; i < nStations; i++) {
    travelTime[i][i] = 0; //distance from the station to itself
                          //is equal to zero, because you are already there 
}