public void addSubgroups()  {
            RealmResource realm =keycloak.realm("myrealm");
            GroupRepresentation topGroup = new GroupRepresentation();
            topGroup.setName("group");
            topGroup = createGroup(realm, topGroup);

            createSubGroup(realm,topGroup.getId(),"subgroup1");
            createSubGroup(realm,topGroup.getId(),"subgroup2");
        }

       private void createSubGroup(RealmResource realm, String parentGroupId, String subGroupName) {
           GroupRepresentation subgroup = new GroupRepresentation();
             subgroup.setName(subGroupName);
           try (Response response = realm.groups().group(parentGroupId).subGroup(subgroup)){
                if (response.getStatusInfo().getFamily() == Family.SUCCESSFUL) {
                    System.out.println("Created Subgroup : " + subGroupName );
                } else {
                    logger.severe("Error Creating Subgroup : " + subGroupName + ", Error Message : " + getErrorMessage(response));
                }
            } 
       }

       private GroupRepresentation createGroup(RealmResource realm, GroupRepresentation group) {
            try (Response response = realm.groups().add(group)) {
                String groupId = getCreatedId(response);           
                group.setId(groupId);
                return group;
            }
        }