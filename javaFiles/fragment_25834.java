/** Index in ranges for MIN. */
  public static final int R_MIN = 0;

  /** Index in ranges for MAX. */

  public static final int R_MAX = 1;

  /** Index in ranges for WIDTH. */
  public static final int R_WIDTH = 2;

  /** the instances used internally. */
  protected Instances m_Data = null;

  /** True if normalization is turned off (default false).*/
  protected boolean m_DontNormalize = false;

  /** The range of the attributes. */
  protected double[][] m_Ranges;

  /** The range of attributes to use for calculating the distance. */
  protected Range m_AttributeIndices = new Range("first-last");

  /** The boolean flags, whether an attribute will be used or not. */
  protected boolean[] m_ActiveIndices;

  /** Whether all the necessary preparations have been done. */
  protected boolean m_Validated;


public double distance(Instance first, Instance second, double cutOffValue, PerformanceStats stats) {
    double distance = 0;
    int firstI, secondI;
    int firstNumValues = first.numValues();
    int secondNumValues = second.numValues();
    int numAttributes = m_Data.numAttributes();
    int classIndex = m_Data.classIndex();

    validate();

    for (int p1 = 0, p2 = 0; p1 < firstNumValues || p2 < secondNumValues; ) {
      if (p1 >= firstNumValues)
        firstI = numAttributes;
      else
        firstI = first.index(p1); 

      if (p2 >= secondNumValues)
        secondI = numAttributes;
      else
        secondI = second.index(p2);

      if (firstI == classIndex) {
        p1++; 
        continue;
      }
      if ((firstI < numAttributes) && !m_ActiveIndices[firstI]) {
        p1++; 
        continue;
      }

      if (secondI == classIndex) {
        p2++; 
        continue;
      }
      if ((secondI < numAttributes) && !m_ActiveIndices[secondI]) {
        p2++;
        continue;
      }

      double diff;

      if (firstI == secondI) {
        diff = difference(firstI,
                  first.valueSparse(p1),
                  second.valueSparse(p2));
        p1++;
        p2++;
      }
      else if (firstI > secondI) {
        diff = difference(secondI, 
                  0, second.valueSparse(p2));
        p2++;
      }
      else {
        diff = difference(firstI, 
                  first.valueSparse(p1), 0);
        p1++;
      }
      if (stats != null)
        stats.incrCoordCount();

      distance = updateDistance(distance, diff);
      if (distance > cutOffValue)
        return Double.POSITIVE_INFINITY;
    }

    return distance;
  }