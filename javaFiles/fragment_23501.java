class ResultArray{
   int index;
   int value;
   public ResultArray(int i, int v){
         index = i;
         value = v;
   }
}
List<ResultArray> nums = new ArrayList<>();
    for(int i = 0; i < result.size(); i++) {
        nums.add(new ResultArray(i, result.get(i)));
    }
    Collections.sort(nums, (a, b) -> a.y > b.y ? -1 : 1);