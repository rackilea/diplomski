queue.add(lessInteger);
        queue.add(middleInteger);
        queue.add(maxInteger);
        lessInteger.addAndGet(30);
        queue.add(new AtomicInteger(5));
        while (queue.size() != 0)
        {
            System.out.println(queue.remove());
        }