String[] parts = path.split("\\/");
NodeRef nodeRef = nodeService.getRootNode(StoreRef.STORE_REF_WORKSPACE_SPACESSTORE);
for (String name : parts) {
   NodeRef child = nodeService.getChildByName(nodeRef, ContentModel.ASSOC_CONTAINS, name);
   if (child == null) 
      throw new Exception("Path part not found "+name+" in "+path+" at "+nodeRef);
   nodeRef = child;
}
return nodeRef;