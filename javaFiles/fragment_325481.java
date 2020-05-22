public boolean isConnected(String s) {
    int nVisited = isConnected(s, new boolean[nodes.size()], 0);
    return nVisited == nodes.size();
}

private int isConnected(String s, boolean[] visited, int counter) 
{

    int in = nodes.indexOf(s);


    visited[in] = true;
    counter++;
    for(int i = 0; i < listOfChildren(s).size(); i++)
    {
        int ind = nodes.indexOf(listOfChildren(s).get(i));
        if(visited[ind] == false)
        {
            counter = isConnected(listOfChildren(s).get(i), visited, counter);
        }

    }
    System.out.println(counter);
    return counter;
}