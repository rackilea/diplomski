set1 = {}
set2 = {}
x = SUM/2
for i from n to 0 decreasing:
   if Q(i,x):
      x = x - arr[i]
      set1.add(arr[i])
   else:
      set2.add(arr[i])