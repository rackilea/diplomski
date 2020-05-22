static int maxLength(int[] a, int k) {
        Map<Integer, Map<Integer, Long>> map = new HashMap<Integer, Map<Integer, Long>>();

        int maxLength = 0;
        for(int i = 0; i < a.length - 1; i++) {
            Map<Integer, Long> map2 = new HashMap<Integer, Long>();
            map2.put(i, (long)a[i]);
            map.put(i, map2);
            if(a[i] == k) {
                maxLength = 1;
            }
        }

        for(int l = 2; l <= a.length; l++) {
            long sum = 0;
            for(int i = 0; i <= a.length - l; i++) {
                int j = i + l - 1;
                Map<Integer, Long> map2 = map.get(i);
                sum = map2.get(j - 1) + a[j];
                map2.put(j, sum);

                if(sum <= k) {
                    if(l > maxLength) {
                        maxLength = l;
                    }
                }
            }
        }

        return maxLength;
    }