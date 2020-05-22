static int minCost(int[][] relations, int[] prev)
{
    PriorityQueue<Person> q = new PriorityQueue<>();

    Person[] person = new Person[relations.length];
    for(int i=0; i<relations.length; i++) 
    {
        person[i] = new Person(i, i==0 ? 0 : Integer.MAX_VALUE);
    }

    q.offer(person[0]);     
    while(!q.isEmpty())
    {
        Person p = q.poll();

        if(p.level == person.length-1) 
            return p.cost;          

        for(int n : relations[p.level])
        {
            int d = p.cost + (n-p.level)*(n-p.level); 
            if(d < person[n].cost)
            {
                q.offer(person[n] = new Person(n, d));
                prev[n] = p.level;
            }
        }
    }       
    return -1;
}

static class Person implements Comparable<Person>
{
    public int level;
    public int cost;

    public Person(int level, int cost)
    {
        this.level = level;
        this.cost = cost;
    }

    @Override
    public int compareTo(Person o)
    {
        return cost - o.cost;
    }
}

static String buildPath(int[] arr, int i, String path)
{
    path = i + " " + path;
    if(i == 0) return path;
    else return buildPath(arr, arr[i], path);
}

public static void main(String[] args) 
{
    int[][] arr ={{1, 2, 3},
                  {8, 6, 4},
                  {7, 8, 3},
                  {8, 1},
                  {6},
                  {8,7},
                  {9, 4},
                  {4, 6},
                  {1},
                  {1,4}};

    int[] prev = new int[arr.length];
    int min = minCost(arr, prev);
    if(min < 0) System.out.println("No path");    
    else System.out.println(min + " : " + buildPath(prev, arr.length-1, ""));        
}