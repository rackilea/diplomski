Node makeTree(int head, int tail){
    nodeMid = (head+tail)/2;
    this = new Node();
    if(head < nodeMid-1)
    {
        this.left = makeTree(head, nodeMid-1);
    }
    if(nodeMid < tail)
    {        
        this.right = makeTree(nodeMid, tail); 
    }
    this.setValue(list[nodeMid]);
    return this;
}