import org.apache.spark.mllib.linalg.Vector;

public static class LabeledPointWithMeta implements Serializable {
  private int userNo;
  private double label;
  private Vector vector;

  public int getUserNo() {
    return userNo;
  }

  public void setUserNo(int userNo) {
    this.userNo = userNo;
  }

  public double getLabel() {
    return label;
  }

  public void setLabel(double label) {
    this.label = label;
  }

  public Vector getVector() {
    return vector;
  }

  public void seVector(Vector vector) {
    this.vector = vector;
  }

}