PathIterator pathIter = path.getPathIterator(null);
    while(!pathIter.isDone()) {
        final double[] segment = new double[6];
        pathIter.currentSegment(segment);
        //do something with segment
        pathIter.next();
    }