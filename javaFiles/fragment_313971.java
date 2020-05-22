int count = 0;

    while ( count < numbers.length) {

      current = Integer.parseInt(numbers[count]);


      if (last != null) {
        if(last == current){
          System.out.println("Duplicates: " + current);
          total = total +1;
        }
      }
      last = current;
      count++;

    }