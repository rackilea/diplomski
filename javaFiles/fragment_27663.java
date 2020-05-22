public static void bfs(){
while(!q.empty()){
  int v = q.poll();
  System.out.println(v);
  visited[v]=true;
  Iterator it = a.get(v);
  while(it.hasNext()){
    int vert = (int)it.next();
    if(!pushed[vert]){
        q.add(vert);
        pushed[vert]=true;
    }
  } 
 }
}