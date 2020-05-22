Map<Integer, Integer> elementsCounts = new HashMap<>();
for (int i = 0; i < arr.length; i++) {
    for (int j = 0; j < arr[i].length; j++) {
        Integer count = elementsCounts.get(arr[i][j]])
        if(count == null){
          count = 0
        }
        elementsCounts.put(arr[i][j]], count+1)
    }
}