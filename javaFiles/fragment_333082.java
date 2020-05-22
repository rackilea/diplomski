int bestDist[N]
int mst[N][N]
int cameHere[N]
bool done[N]
FOR i = 0..N-1:
 bestDist[i] = INFINITY
 done[i] = false
 FOR j=0..N-1:
  mst[i][j] = INFINITY

// start at any node
bestDist[0] = 0;
FOR i = 0..N-1:
 bestNode = INFINITY
 bestNodeDist = INFINITY

 IF bestNode != 0:
  mst[cameHere[bestNode]][bestNode] = graph[cameHere[bestNode]][bestNode]

 // find closest node
 FOR j= 0..N-1:
  IF !done[j] AND bestDist[j] < bestNodeDist:
   bestNode = j
   bestNodeDist = bestNodeDist[j]

 // update surrounding nodes
 FOR j=0..N-1:
  IF !done[j] AND bestNodeDist + graph[bestNode][j] < bestDist[j]:
   bestDist[j] = bestNodeDist + graph[bestNode][j]
   cameHere[j] = bestNode

return mst