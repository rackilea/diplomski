struct Node node = {"Adam", 1, NULL, NULL};
struct Node *nodePtr = &node;

printf("word[%s] count[%d] left[%p] right[%p]\n",
  node.word, node.count, node.left, node.right);

printf("word[%s] count[%d] left[%p] right[%p]\n",
  nodePtr->word, nodePtr->count, nodePtr->left, nodePtr->right);