public <E extends T> void add(E value) 
{ 
if(root == null) { // If there’s no root node 
 root = new Node(value);          // store it in the root 
}  
else {    // Otherwise... 
add(value, root);  // add it recursively
 } 
}