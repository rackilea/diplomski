@InitBinder
public void webFormDataBinder( WebDataBinder webDataBinder ){
    webDataBinder.registerCustomEditor(Set.class, "roles", new CustomCollectionEditor(Set.class){
        RoleEntity roleEntity = null;
        @Override
        protected Object convertElement(Object element) {
            roleEntity = new RoleEntity();
            roleEntity.setRoleId( element.toString() );
            return roleEntity;
        }
    });
}