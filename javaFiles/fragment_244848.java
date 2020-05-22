private ArrayList fillGroups(){

         List <Group> groupsList=new ArrayList();

        Group adminGroup =new Group();
        Group sectionAdminGroup =new Group();
        Group userGroup =new Group();

        adminGroup.setId(1);
        sectionAdminGroup.setId(2);
        userGroup.setId(3);


        adminGroup.seteName("Admin");
        sectionAdminGroup.seteName("Section Admin");
        userGroup.seteName("User");

        adminGroup.setaName("مشرف عام");
        sectionAdminGroup.setaName("مشرف قطاع");
        userGroup.setaName("مستخدم");


        groupsList.add(adminGroup);
        groupsList.add(sectionAdminGroup);
        groupsList.add(userGroup);


        System.out.println("he call fillGroup....");
        return (ArrayList) groupsList;

    }

     @ModelAttribute("Group")
     private  void fillData(ArrayList<Group> list){

         for (Group group:list){
           usersService.addObject(group);
         }
     }