// first compare scores
if (o1.score>o2.score) return -1; /* higher score for o1 -> o1 */
if (o1.score<o2.score) return 1; /* higher score for o2 -> o2 */

// scores are equal, go on with the position
if (o1.seq1start+o1.seq2start < o2.seq1start+o2.seq2start) return -1; /* o1 is farther left */
if (o1.seq1start+o1.seq2start > o2.seq1start+o2.seq2start) return 1; /* o2 is farther left */

// they're equally good
return 0;