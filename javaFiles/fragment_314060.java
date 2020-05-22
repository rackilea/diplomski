List<Integer> removeBackward(List<Integer> numbers) {
    int count, sPos;
    count = 2;
    while(count<=numbers.size())
    {
      for(sPos = numbers.size(); sPos >= numbers.size()-count; sPos--)
      {
        if(0 == sPos%count) {
          break;
        }
      }
      for(int pos = sPos; pos > 0; pos=pos-count)
      {
        numbers.remove(pos-1);
      }
      count++;           
    } 
    return numbers;
  }