// relative path in web.app
private Classifier getClassifier() throws Exception
{
    String relativeWebPath = "/ModelFiles/J48.model";
    String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
    return (Classifier) weka.core.SerializationHelper.read(absoluteDiskPath);
}