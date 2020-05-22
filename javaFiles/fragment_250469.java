Node result;
result = this.searchNode(n._leftChild, c);
if (result != null)
   return result;
result = this.searchNode(n._rightChild, c);
if (result != null)
   return result;