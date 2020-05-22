void mergeStreams(List<Stream> streams, int k) {
    while (streams.size() >= k) { // each loop checks one value (the current minimum)
        int minCount = 0;
        int min = Integer.MAX_VALUE;
        List<Stream> minStreams = new ArrayList<>();

        Iterator<Stream> streamIter = streams.iterator(); // supports remove during iteration
        while (streamIter.hasNext()) {
            Stream stream = streamIter.next();
            if (!stream.hasNext()) {
                streamIter.remove(); // remove stream from original list
                continue;
            }
            if (stream.peek() <= min) {
                if (stream.peek() == min) {
                    minCount++;
                } else {
                    minStreams = new ArrayList<>();
                    min = stream.peek();
                    minCount = 1;
                }
                minStreams.add(stream);
            }
        }
        if (minCount >= k) { // runs after iterating over streams
            System.out.println(min);
        }
        for (Stream s : minStreams) { // must advance past the current min value
            if (s.hasNext()) {
                s.next();
            } else {
                streams.remove(s);
            }
        }
    }
}