private static int strongestEven(int from, int to) {
  if (to < from)
    return -1; // Or throw exception

  // best power of 2 we can insert between [to..from] as k * best
  int best = 1;

  while (true) {
    int ceiling = from / best + (from % best == 0 ? 0 : 1);
    int floor = to / best;

    if (ceiling > floor) {
      best = best / 2;

      return best * (to / best);
    }

    best *= 2;
  }
}