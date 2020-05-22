for (i=0;i<5;i++){
    g.element = new grid(); 
    g.element.x=i;          //adding 5 elements to the queue with 
    g.element.y=i;          // x,y having different value eatch time
    g.myqueue.add(g.element);
}