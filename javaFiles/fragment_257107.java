while (stack.size() != 0)
    {
        s = stack.pop();
        if(visited[s]) //add these two lines
                continue; 
        System.out.print(s+" ");
        Iterator<Edge> i = G[s].listIterator();
        if (!visited[s])
            {
                visited[s] = true;
                while (i.hasNext())
                {
                   int n = i.next().v;
                   stack.push(n);
                }
            }

    }