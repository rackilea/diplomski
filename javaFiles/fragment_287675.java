int grade;
    if(points >49){
        grade=5;
    }else if(points >44){
        grade=4;
    }else if(points >39){
        grade=3;
    }else if(points >34){
        grade=2;
    }else if(points >29){
        grade=1;
    }else{
        grade=0;

  }
    System.out.println("Gr: "+grade); //grade=0 = not passed