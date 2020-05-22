-- class Bar

final int x;

Bar(int x, int ignore)
{
    this.x = x;  // assign to final
}  // [f] freeze action on this.x

public Bar(int x)
{ 
    this(x, 0);
    // [f] is reached!
    leak(this); 
}