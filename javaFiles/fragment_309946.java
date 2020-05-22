insertData(15);
insert(node,root) // here root is your actuall root, originally initialized when u inserted first

// it goes to last else if inside insert api
root1.setRightChild(insert(node,root1.getRightChild())); // see now, this apis actually calls insert again, coz new node value was greater then root value

// this is how next stack trace will look like, as root right child was null
insert(node,null); // observer second argument is null again