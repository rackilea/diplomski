long finSum = 0;  // Might as well be a long
float[] idealValues = new float[size];
for (int i = 0 ; i < ret.length; i++) {
    ideal[i] = (sum * ret[i]) / iniSum;
    ret[i] = (long) (ideal[i]);  // Truncate, not round
    System.out.println("ret[" + i +"] = " + ret[i]);
    finSum += ret[i];
}

/* There are iniSum - finSum extra amounts to add. */
for (int i = 0; i < iniSum - finSum; i++)
{
    /* Pick a target slot to increment.  This could be done by keeping a priority queue. */
    int target = 0;
    float bestScore = 0.0;
    for (int j = 0; j < size; j++) {
        float score = (ideal[j] - ret[j])/ret[j];
        if (score > bestScore) {
            target = j;
            bestScore = score;
        }
    }

    /* Allocate an additional value to the target. */
    ret[target]++;
}