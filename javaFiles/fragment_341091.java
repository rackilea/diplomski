int price[] =  {12,14,21,14,17,22,11,16,17,12,30,25,27,24,22,15,24,23,15,21}; //total 20 stations

int distance[] = {31,42,31,33,12,34,55,25,34,64,24,13,52,33,23,64,43,25,15};  //total 19 distances      

int N=19;
int[] cost = new int[N];    
int[] parent = new int[N]; //for backtracking

cost[0] = 0; //base case (assume that we don't need to fill gas on station 0)

int i,j,dist;
int maxroad = 170;

for(i=0; i<N; i++) //initialize backtracking array
    parent[i] = -1;


for(i=1; i<=N-1; i++) //for every station from 1 to 18
{

        int priceval = price[i]; //get price of station i               
        int min = Integer.MAX_VALUE;                
        dist = 0;            

        for(j=i-1; j>=0; j--) //for every station j within 170 away from station i
        {   
            dist += distance[j]; //distance[j] is distance from station j to station j+1
            if(dist>maxroad)
               break;   

            if((cost[j] + priceval*dist)<min) //pick MIN value defined in recurrence relation                       
               {
                min = cost[j] + priceval*dist;
                parent[i] = j;
               }

        }

        cost[i] = min;              

}


//after all costs from cost[1] up to cost[18] are found, we pick
//minimum cost among the stations within 170 miles away from station 19
//and show the stations we stopped at by backtracking from end to start

int startback=N-1;
int answer=Integer.MAX_VALUE;
i=N-1;
dist=distance[i];
while(dist<=maxroad && i>=0)
{
   if(cost[i]<answer)
      {
       answer = cost[i];
       startback=i;
      }  
   i--;
   dist += distance[i];
}


System.out.println("minimal cost=" + answer + "\nbacktrack:");

i=startback;
while(i>-1) //backtrack
{
    System.out.println(i + " ");
    i = parent[i];
}