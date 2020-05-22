if(menuListMap.containsKey(menu_group_name)){
                       menuNamesList =(List) menuListMap.get(menu_group_name);
                       menuViewModel = new MenuListViewModel();
                       menuViewModel.setResource_name(resource_name);
                       menuViewModel.setMenu_name(menu_name);
                       menuNamesList.add(menuViewModel);
                       menuListMap.put(menu_group_name, menuNamesList);
                   }else{
                       menuNamesList = new ArrayList<MenuListViewModel>();
                       menuViewModel = new MenuListViewModel();
                       menuViewModel.setResource_name(resource_name);
                       menuViewModel.setMenu_name(menu_name);
                       menuNamesList.add(menuViewModel);
                       menuListMap.put(menu_group_name, menuNamesList);
                   }