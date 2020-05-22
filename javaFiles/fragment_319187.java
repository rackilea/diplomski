final permissionService = serviceRegistry.getPermissionService();
//Read the username of the current user
final String loggedInUser = authenticationService.getCurrentUserName();

ChildAssociationRef childAssociationRef = nodeService.getPrimaryParent(actionedUponNodeRef);

//Get the parent NodeRef
NodeRef parent = childAssociationRef.getParentRef();
String fileName = (String) nodeService.getProperty(parent, ContentModel.PROP_NAME);

//Iterate till you get to document library
while(!fileName.contains("documentLibrary")){
    ChildAssociationRef childAssociationRef2 = nodeService.getPrimaryParent(parent);
    parent = childAssociationRef2.getParentRef();
    //Have to declare a final variable in order to access it in the RunAsWork
    final NodeRef ref = parent;

    fileName = (String) nodeService.getProperty(parent, ContentModel.PROP_NAME);

    AuthenticationUtil.runAsSystem(new AuthenticationUtil.RunAsWork<Object>() {
      public Object doWork() throws Exception {
       permissionService.setPermission(ref, loggedInUser, PermissionService.CONTRIBUTOR, true);
       return "";
      }

    });
}