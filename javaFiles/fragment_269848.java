Mat mat = ...
Mat matTemplate = ...
// Create the result matrix
int resultCols = mat.cols() - matTemplate.cols() + 1;
int resultRows = mat.rows() - matTemplate.rows() + 1;
if ( resultCols > 0 && resultRows > 0 ) {   
Mat result = new Mat(resultRows, resultCols, CvType.CV_8UC1);
// Do the Matching
Imgproc.matchTemplate(mat, matTemplate, result, Imgproc.TM_CCOEFF_NORMED);
//  Normalize???
// Localizing the best match with minMaxLoc
MinMaxLocResult mmr = Core.minMaxLoc(result);