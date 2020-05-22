set1 = {}
set2 = {}
x = SUM/2
for i from n to 0 decreasing:
   if D(i-1,x-arr[i]): 
//   ^^ The condition was changed ^^
      x = x - arr[i]
      set1.add(arr[i])
   else:
      set2.add(arr[i])