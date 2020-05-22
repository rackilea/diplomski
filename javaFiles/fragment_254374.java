AddClassification filter = new AddClassification() {
  protected Classifier getActualClassifier() {
    ObjectInputStream   ois;

    if (m_ActualClassifier == null) {
      try {
        ois = new ObjectInputStream(
                     this.getClass().getResourceAsStream("classifier.ser"));
        m_ActualClassifier = (Classifier) ois.readObject();
        m_SerializedHeader = null;
        // let's see whether there's an Instances header stored as well
        try {
          m_SerializedHeader = (Instances) ois.readObject();
        }
        catch (Exception e) {
          // ignored
          m_SerializedHeader = null;
        }
        ois.close();
      }
      catch (Exception e) {
        m_ActualClassifier = null;
        System.err.println("Failed to instantiate classifier:");
        e.printStackTrace();
      }
    }

    return m_ActualClassifier;
  }
};

filter.setInputFormat(labeled);
String[] options = new String[3];
options[0] = "-serialized";
options[1] = "/dev/null";
options[2] = "-classification";
filter.setOptions(options);