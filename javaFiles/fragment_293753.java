Integer[] ints = new Integer[]{3,2,1};

    // For reverse of natural order i.e. largest to smallest
    // If you want the natural order don't use the Collections.reverseOrder() comparator
    Queue<Integer> queue = new PriorityQueue<Integer>(ints.length, Collections.reverseOrder());
    queue.addAll(Arrays.asList(ints));

    while (queue.size() > 0) {
        System.out.println(queue.poll());
    }