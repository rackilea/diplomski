/** 
 * Returns the height of the normal distribution at the specified z-score
 */
double getNormalProbabilityAtZ(double z) {
    return Math.exp(-Math.pow(z, 2) / 2) / Math.sqrt(2 * Math.PI);
}