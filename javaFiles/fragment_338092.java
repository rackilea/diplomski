public void add_roles(List<List<Integer>> user_roles){
    // instantiate array list
    for(Role role : instance.get_RoleObjects()){
        if(user_roles.get(0).contains(role.role_id)){
            // Make roles a List<Role> only
            roles.add(role); // Use the roles object on THIS
            System.out.println("\nUser has role " + role.role_name );
        }
        System.out.println("\nUser dosnt have role" + role.role_name");
    }
}