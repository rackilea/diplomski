double[] target = new double[doubles.size()];
 for (int i = 0; i < target.length; i++) {
    target[i] = doubles.get(i).doubleValue();  // java 1.4 style
    // or:
    target[i] = doubles.get(i);                // java 1.5+ style (outboxing)
 }