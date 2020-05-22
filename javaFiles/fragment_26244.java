int outdegree[n]={0}; // Storing outdegree of each node
int indegree[n]={0}; /// Storing indegree of each node


 while(m--)  // m is number of edges
 {
    scanf("%d %d",&a,&b);  // this means there is an edge from 'a' to 'b'. a-->b
    outdegree[a]++;
    indegree[b]++;
 }
 int sink;  
 for(i=1;i<=n;i++)
 {
    if((outdegree[i]==0 )&& (indegree[i]==(n-1)))
        sink=i;
 }
 cout<<"Sink/Pit is: "<<sink<<endl;