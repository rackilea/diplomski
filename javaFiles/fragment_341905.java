import weka.core.Instance;

public class WekaWrapper {

  /**
   * Classifies the given instance.
   *
   * @param i the instance to classify
   * @return the classification result
   */
  public double[] classifyInstance(Instance i) throws Exception {
    Object[] s = new Object[i.numAttributes()];

    for (int j = 0; j < s.length; j++) {
      if (!i.isMissing(j)) {
        if (i.attribute(j).isNominal())
          s[j] = new String(i.stringValue(j));
        else if (i.attribute(j).isNumeric())
          s[j] = new Double(i.value(j));
      }
    }

    // set class value to missing
    s[i.classIndex()] = null;

    return WekaClassifier.classify(s);
  }
}
class WekaClassifier {
  public static double[] classify(Object[] i) {
    /* outlook */
      double[][] here=new double[3][2];
      here[0][0]=0; //leaf value
      here[0][1]=1; //leaf ID
      here[1][0]=0; //leaf value
      here[1][1]=2; //leaf ID
      here[2][0]=0; //leaf value
      here[2][1]=3; //leaf ID
    if (i[0] == null) { return here[0]; } else if (((String)i[0]).equals("overcast")) { return here[1]; } else { return here[2]; }
  }
}