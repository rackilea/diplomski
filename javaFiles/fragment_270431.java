class MyTable{
      MyTable(Integer id,String col1, Boolean isColumn2){
          this.id = id;
          if(isColumn2){
             this.col2 = col2;
          }
          else{
             this.col1 = col1;
          }
      }      
}