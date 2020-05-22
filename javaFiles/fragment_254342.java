Object o;
TreeNode valueTreeNode = jp.readValueAsTree();
// check if array or valueNode
// but if is object
ObjectMapper om = new ObjectMapper();
o = om.treeToValue(valueTreeNode, Map.class);
return o;