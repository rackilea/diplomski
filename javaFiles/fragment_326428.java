String dataClassifications = "";
for (int i = 0; i < matTrainingImagesAsFlattenedFloats.rows(); i++) {
    for (int j = 0; j < matTrainingImagesAsFlattenedFloats.cols(); j++) {
        double[] temp = matTrainingImagesAsFlattenedFloats.get(i, j);
        dataClassifications += temp[0] + " ";
    }
    dataClassifications += "\n";
}