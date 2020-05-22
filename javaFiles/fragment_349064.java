// a global object for tag strings
nodeNames = new ArrayList<>();

// populate tag list by reading them from first element
listNodes(nodeList.item(0).getChildNodes(), false);

// list nodes, notice the second parameter is boolean
listNodes(nodeList,true);