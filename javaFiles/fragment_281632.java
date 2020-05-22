static int bisect_left(int[] num, int x)
   {
      int low = 0;
      int high = num.length - 1;

      while (low < high)
      {
         int mid = (low + high) / 2;

         if (num[mid] >= x)
            high = mid - 1;
         else
            low = mid + 1;
      }

      return (num[low] < x) ? low + 1 : low;
   }

   static int[] solution(int[] arr, int[] queries)
   {
      Arrays.sort(arr); // O(n log n)

      int N = arr.length;

      int[] results = new int[queries.length];
      int[] sc = new int[N + 1];
      sc[0] = 0;
      sc[1] = arr[0];

      for (int i = 1; i < N; i++)
         sc[i + 1] = sc[i] + arr[i];

      int q = 0;
      for (int i = 0; i < queries.length; i++)  //  O(m)
      {
         q += queries[i];

         int n = bisect_left(arr, -q);  //  O(log n)

         results[i] = sc[N] + q * N - 2 * (sc[n] + q * n);
      }

      return results;
   }