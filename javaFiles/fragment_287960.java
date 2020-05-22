@SuppressWarnings("unchecked")
private List<IAnalysisData> deserialize(byte[] bytes) throws IOException, ClassNotFoundException
{
    List<IAnalysisData> analysisDataList = null;
    ByteArrayInputStream in = new ByteArrayInputStream(bytes);
    ObjectInputStream oos = new ObjectInputStream(in);
    Object o = oos.readObject();

    analysisDataList = (List<IAnalysisData>) o; //warning here
    return analysisDataList;
}