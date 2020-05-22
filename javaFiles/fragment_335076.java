public static int getMode(int[] values) {
  HashMap<Integer,Integer> freqs = new HashMap<Integer,Integer>();

  for (int val : values) {
    Integer freq = freqs.get(val);
    freqs.put(val, (freq == null ? 1 : freq+1));
  }

  int mode = 0;
  int maxFreq = 0;

  for (Map.Entry<Integer,Integer> entry : freqs.entrySet()) {
    int freq = entry.getValue();
    if (freq > maxFreq) {
      maxFreq = freq;
      mode = entry.getKey();
    }
  }

  return mode;
}