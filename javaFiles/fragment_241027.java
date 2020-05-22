cv::Mat drawing = cv::imread(_drawing); //Read drawing
cv::Mat tmp = cv::imread(_tmp);  //Read template
cv::Mat res(drawing.rows - tmp.rows + 1, drawing.cols - tmp.cols + 1, CV_32FC1); //Create result matrix

//Perform template matching, normalise results 0 -> 1
cv::matchTemplate(tmp, drawing, res, CV_TM_CCOEFF_NORMED);
cv::threshold(res, res, 0.8, 1.0, CV_THRESH_TOZERO); //Can thresh to filter results if needed