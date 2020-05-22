int[] scores = new int[]{5, 7, 10, 3, 6};
int[] scores_sorted = scores.clone();
int[] places = new int[]{0,1,2,3,4};
sort(scores_sorted);
for(int i=0;i<5;++i){
    for(int j=0;j<5;++j){
        if(scores_sorted[i]-scores[j] == 0){
             places[i] = j;
          }
     }
}