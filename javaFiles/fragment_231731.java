int[] starts = new int[]{4, 5, 6};
int[] limits = new int[]{7, 8, 10};
int[] incrementers = new int[]{1, 2, 3}; // elements cannot be <= 0
int[] params = starts.clone(); // must be a clone of starts

doCalculations(starts, limits, incrementers, params, 0);