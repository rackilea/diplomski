public static int indexOfSubList(int[] source, int[] target) {
  int sourceSize = source.length;
  int targetSize = target.length;
  int maxCandidate = sourceSize - targetSize;

  nextCand:
    for (int candidate = 0; candidate <= maxCandidate; candidate++) {
      for (int i=0, j=candidate; i<targetSize; i++, j++)
        if (!(target[i] == source[j]))
          continue nextCand;  // Element mismatch, try next cand
      return candidate;  // All elements of candidate matched target
    }
  return -1;  // No candidate matched the target
}