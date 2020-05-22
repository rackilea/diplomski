public class UndirectedConnectivityDfs
{
    private Stack<Integer> stack;
    public UndirectedConnectivityDfs() 
    {
            stack = new Stack<Integer>();
    } 

    public void dfs(int adjacency_matrix[][])
    {
        int number_of_nodes = adjacency_matrix[0].length;   
        int visited[] = new int[number_of_nodes];       
        int cc = 0;
        for  (int vertex = 0; vertex < number_of_nodes; vertex++)
        {
            if (visited[vertex] == 0)
            {   
                int element = vertex;               
                int i = vertex;     
                visited[vertex] = 1;
                cc++;
                stack.push(vertex);
                while (!stack.isEmpty())
                {
                    element = stack.peek();
                    i = element;    
                    while (i < number_of_nodes)
                    {
                        if (adjacency_matrix[element][i] == 1 && visited[i] == 0)
                        {
                            stack.push(i);
                            visited[i] = 1;
                            element = i;
                            i = 1;
                            continue;
                            }
                            i++;
                    }
                    stack.pop();    
                }
            }
        }
        System.out.println("Number of Connected Components: " + cc);
    }

    public static void main(String...arg)
    {
        int number_of_nodes;
        Scanner scanner = null;
        try
        {
            System.out.println("Enter the number of nodes in the graph");
            scanner = new Scanner(System.in);

            number_of_nodes = scanner.nextInt();
            int adjacency_matrix[][] = new int[number_of_nodes][number_of_nodes];

            System.out.println("Enter the adjacency matrix");

            for (int i = 0; i < number_of_nodes; i++)
                for (int j = 0; j < number_of_nodes; j++)
                       adjacency_matrix[i][j] = scanner.nextInt();

            for (int i = 0; i < number_of_nodes; i++)
            {
                for (int j = 0; j < number_of_nodes; j++)
                {   
                    if (adjacency_matrix[i][j] == 1 && adjacency_matrix[j][i] == 0)
                    {
                            adjacency_matrix[j][i] = 1;
                    }
                    }
            }           
            UndirectedConnectivityDfs undirectedConnectivity= new UndirectedConnectivityDfs();
            undirectedConnectivity.dfs(adjacency_matrix);   

        }catch(InputMismatchException inputMismatch)
        {
            System.out.println("Wrong Input format");
        }   
        scanner.close();    
    }   
}