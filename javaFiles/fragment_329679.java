/*
 * Tuning parameters for algorithms - Many of the List algorithms have
 * two implementations, one of which is appropriate for RandomAccess
 * lists, the other for "sequential."  Often, the random access variant
 * yields better performance on small sequential access lists.  The
 * tuning parameters below determine the cutoff point for what constitutes
 * a "small" sequential access list for each algorithm.  The values below
 * were empirically determined to work well for LinkedList. Hopefully
 * they should be reasonable for other sequential access List
 * implementations.  Those doing performance work on this code would
 * do well to validate the values of these parameters from time to time.
 * (The first word of each tuning parameter name is the algorithm to which
 * it applies.)
 */
private static final int BINARYSEARCH_THRESHOLD   = 5000;