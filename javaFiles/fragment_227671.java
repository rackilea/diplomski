void printGraph ()
{
    for(int i=0;i<G.length;i++) {
        for (Node node: G[i]) {
            System.out.println(i+"=>"+node+"\n");
        }
    }
}