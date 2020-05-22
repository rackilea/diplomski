public static int minJumps2(int[] arr, List<Integer> jumps) {
        boolean reachedEnd = false;
        if (arr.length < 2)
            return 0;

        //calculate (index + value)
        int[] sums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sums[i] = i + arr[i];
        }
        // start with first index
        jumps.add(0);

        while (true) {
            int currentPosition = jumps.get(jumps.size() - 1);
            int jumpValue = arr[currentPosition];

            // See if we can jump to the goal
            if (arr.length - 1 - currentPosition <= jumpValue) {
                jumps.add(arr.length - 1);
                reachedEnd = true;
                break;
            } else {
                int maxIndex = currentPosition;
                int currentMax = sums[maxIndex];
                // max of the reachable elements
                for (int i = currentPosition; i <= currentPosition + jumpValue; i++) {
                    if (sums[i] > currentMax) {
                        maxIndex = i;
                        currentMax = sums[i];
                    }
                }
                if (maxIndex == currentPosition) { 
                    break; 
                }

                jumps.add(maxIndex);
            }
        }
        System.out.println(jumps.size());
        System.out.println(jumps);
        return jumps.size();
    }