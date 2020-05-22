//Loop through all results
while (true){

    //Pull out min/max values from results matrix
    cv::minMaxLoc(res, &min, &max, &minloc, &maxloc);

    //Is max within tolerance
    if (max >= tolerance){

        //Yes - Match found, do stuff //

        //Blank out that result in matrix so next highest can be extracted
        cv::floodFill(res, maxloc, cv::Scalar(0), 0, cv::Scalar(0.1), cv::Scalar(1.0));

    }
    else
        break; //No more results within tolerance, break search
}