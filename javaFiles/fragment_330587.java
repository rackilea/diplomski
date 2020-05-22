public bool contains(int[][] container, int[][] isContained){
 bool miss = false;
 for(int i = 0; i < isContained.length && !miss; i++){
     for(int j = 0; j < isContained[i].length && !miss; j++){
        if(container.length > i && container[i].length > j){
            if(container[i][j] == isContained[i][j]) {
               continue;
            }
        }
        miss = true;
     }
 }

 return !miss;

}