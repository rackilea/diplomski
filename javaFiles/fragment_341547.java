MenuItem root = null;
MenuItem curr = myMenuItem;
while(curr.getParent() != null) {
    curr = curr.getParent(); 
}
root = curr;