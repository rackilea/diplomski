if (userxp <level2xp){
        userlevel=1;
    }else if ( userxp <level3xp){
        userlevel=level2;
        System.out.println(userlevel);
    }else if ( userxp <level4xp){
        userlevel=level3;
        System.out.println(userlevel);
    }else if (userxp <level5xp){
        userlevel=level4;
    }else if (userxp == level5xp){
        userlevel=level5;
    }else{
        System.out.println("You are a cheat");
    }