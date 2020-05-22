void breadth_first(Node root):
  Queue q;
  q.push(root);
  breadth_first_recursive(q)

void breadth_first_recursive(Queue q):
  if q.empty() return;

  Node n = q.pop()
  print "Node: ", n
  if (n.left) q.push(n.left)
  if (n.right) q.push(n.right)
  breadth_first_recursive(q)