List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);
int result = 0;
for(int e: values){
  if(e > 3 && e % 2 == 0){
    result = e * 2;
    break;
  }
}