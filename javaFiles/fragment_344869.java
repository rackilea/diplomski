for(int i = 0; i < a.length; i++) {
     counts[a[i]]++;

     if(counts[a[i]] > maxCount) {
          maxCount = counts[a[i]];
          maxKey = a[i];
      }
      if(counts[a[i]] == maxCount && counts[a[i]] < maxKey) {
        maxKey = a[i];
      }
}
System.out.println(a[maxKey]);