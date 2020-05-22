/**
 * Custom implementation of {@link AdjustedCosineSimilarity}
 * 
 * @author dmilchevski
 *
 */
public class AdjustedCosineSimilarity extends AbstractSimilarity {

  /**
   * Creates new {@link AdjustedCosineSimilarity}
   * 
   * @param dataModel
   * @throws TasteException
   */
    public AdjustedCosineSimilarity(DataModel dataModel)
            throws TasteException {
        this(dataModel, Weighting.UNWEIGHTED);
    }

    /**
     * Creates new {@link AdjustedCosineSimilarity}
     * 
     * @param dataModel
     * @param weighting
     * @throws TasteException
     */
    public AdjustedCosineSimilarity(DataModel dataModel, Weighting weighting)
            throws TasteException {
        super(dataModel, weighting, true);
        Preconditions.checkArgument(dataModel.hasPreferenceValues(),
                "DataModel doesn't have preference values");
    }

    /**
     * Compute the result
     */
    @Override
    double computeResult(int n, double sumXY, double sumX2, double sumY2, double sumXYdiff2) {
        if (n == 0) {
            return Double.NaN;
        }
        // Note that sum of X and sum of Y don't appear here since they are
        // assumed to be 0;
        // the data is assumed to be centered.
        double denominator = Math.sqrt(sumX2) * Math.sqrt(sumY2);
        if (denominator == 0.0) {
            // One or both parties has -all- the same ratings;
            // can't really say much similarity under this measure
            return Double.NaN;
        }
        return sumXY / denominator;
    }

    /**
     * Gets the average preference
     * @param prefs
     * @return
     */
    private double averagePreference(PreferenceArray prefs){
        double sum = 0.0;
        int n = prefs.length();
        for(int i=0; i<n; i++){
            sum+=prefs.getValue(i);
        }
        if(n>0){
            return sum/n;
        }
        return 0.0d;
    }

    /**
     * Compute the item similarity between two items
     */
    @Override
    public double itemSimilarity(long itemID1, long itemID2) throws TasteException {
        DataModel dataModel = getDataModel();
        PreferenceArray xPrefs = dataModel.getPreferencesForItem(itemID1);
        PreferenceArray yPrefs = dataModel.getPreferencesForItem(itemID2);
        int xLength = xPrefs.length();
        int yLength = yPrefs.length();

        if (xLength == 0 || yLength == 0) {
            return Double.NaN;
        }

        long xIndex = xPrefs.getUserID(0);
        long yIndex = yPrefs.getUserID(0);
        int xPrefIndex = 0;
        int yPrefIndex = 0;

        double sumX = 0.0;
        double sumX2 = 0.0;
        double sumY = 0.0;
        double sumY2 = 0.0;
        double sumXY = 0.0;
        double sumXYdiff2 = 0.0;
        int count = 0;

        // No, pref inferrers and transforms don't appy here. I think.

        while (true) {
            int compare = xIndex < yIndex ? -1 : xIndex > yIndex ? 1 : 0;
            if (compare == 0) {
                // Both users expressed a preference for the item
                double x = xPrefs.getValue(xPrefIndex);
                double y = yPrefs.getValue(yPrefIndex);
                long xUserId = xPrefs.getUserID(xPrefIndex);
                long yUserId = yPrefs.getUserID(yPrefIndex);

                double xMean = averagePreference(dataModel.getPreferencesFromUser(xUserId));
                double yMean = averagePreference(dataModel.getPreferencesFromUser(yUserId));

                sumXY += (x - xMean) * (y - yMean);
                sumX += x;
                sumX2 += (x - xMean) * (x - xMean);
                sumY += y;
                sumY2 += (y - yMean) * (y - yMean);
                double diff = x - y;
                sumXYdiff2 += diff * diff;
                count++;
            }
            if (compare <= 0) {
                if (++xPrefIndex == xLength) {
                    break;
                }
                xIndex = xPrefs.getUserID(xPrefIndex);
            }
            if (compare >= 0) {
                if (++yPrefIndex == yLength) {
                    break;
                }
                yIndex = yPrefs.getUserID(yPrefIndex);
            }
        }

        double result;

        // See comments above on these computations
        double n = (double) count;
        double meanX = sumX / n;
        double meanY = sumY / n;
        // double centeredSumXY = sumXY - meanY * sumX - meanX * sumY + n *
        // meanX * meanY;
        double centeredSumXY = sumXY - meanY * sumX;
        // double centeredSumX2 = sumX2 - 2.0 * meanX * sumX + n * meanX *
        // meanX;
        double centeredSumX2 = sumX2 - meanX * sumX;
        // double centeredSumY2 = sumY2 - 2.0 * meanY * sumY + n * meanY *
        // meanY;
        double centeredSumY2 = sumY2 - meanY * sumY;
//      result = computeResult(count, centeredSumXY, centeredSumX2,
//              centeredSumY2, sumXYdiff2);

        result = computeResult(count, sumXY, sumX2, sumY2, sumXYdiff2);

        if (!Double.isNaN(result)) {
            result = normalizeWeightResult(result, count,
                    dataModel.getNumUsers());
        }
        return result;
    }

}