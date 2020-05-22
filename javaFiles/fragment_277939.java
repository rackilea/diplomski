typedef
struct Node
{
    int x, y;
    // x and y are array indices
}
Node;

typedef
struct Path
{
    int maxlen, head;
    Node * path;
    // maxlen is size of path, head is the index of the current node
    // path is the pointer to the node array
}
Path;

int    node_compare(Node * n1, Node * n2); // returns true if nodes are equal, else false

void   path_setup(Path * p, Node * n); // allocates Path.path and sets first node
void   path_embiggen(Path * p);        // use realloc to make path bigger in case it fills up
int    path_toosmall(Path * p);        // returns true if the path needs to be reallocated to add more nodes
Node * path_head(Path * p);            // returns the head node of the path
void   path_push(Path * p, Node * n);  // pushes a new head node onto the path
void   path_pop(Path * p);             // pops a node from path