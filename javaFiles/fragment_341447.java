while( num > 0 ) {
  nums[count] = num;
  count = count + 1;
  sum += num;
  num = kbd.nextInt();
 }

average = sum / count;