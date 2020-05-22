@SuppressWarnings("unchecked")
        @RequestMapping(method=RequestMethod.GET)
          public String listUsers(Map<String, Object> map) {
            List <Group> groupsList=(ArrayList<Group>)usersService.getAllObjects(Group.class);
            map.put("user", new User());
            map.put("usersList", usersService.getAllObjects(User.class));
            map.put("groupsList", usersService.getAllObjects(Group.class));

            if (groupsList.size()!=0){
                for (Group group:groupsList){
                    }
            }else{
                fillData(fillGroups());
                map.put("groupsList", usersService.getAllObjects(Group.class));     
            }
            return "index";
        }