btnAanmaken.setOnAction(e ->{
       if (index < 10){
            index++;
            user[index]=txtUsername.getText();
            pas[index]=txtUsername.getText();
            System.out.println(pas[index]);
       }else{
          System.out.println("the arrays reaches the max size!");
       } 
       });