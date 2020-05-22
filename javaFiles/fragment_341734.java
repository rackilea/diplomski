// ratio test
    LinkedList<DMatch> good_matches = new LinkedList<DMatch>();
    for (Iterator<MatOfDMatch> iterator = matches.iterator(); iterator.hasNext();) {
        MatOfDMatch matOfDMatch = (MatOfDMatch) iterator.next();
        if (matOfDMatch.toArray()[0].distance / matOfDMatch.toArray()[1].distance < 0.9) {
            good_matches.add(matOfDMatch.toArray()[0]);
        }
    }

    // get keypoint coordinates of good matches to find homography and remove outliers using ransac
    List<Point> pts1 = new ArrayList<Point>();
    List<Point> pts2 = new ArrayList<Point>();
    for(int i = 0; i<good_matches.size(); i++){
        pts1.add(keypoints1.toList().get(good_matches.get(i).queryIdx).pt);
        pts2.add(keypoints2.toList().get(good_matches.get(i).trainIdx).pt);
    }

    // convertion of data types - there is maybe a more beautiful way
    Mat outputMask = new Mat();
    MatOfPoint2f pts1Mat = new MatOfPoint2f();
    pts1Mat.fromList(pts1);
    MatOfPoint2f pts2Mat = new MatOfPoint2f();
    pts2Mat.fromList(pts2);

    // Find homography - here just used to perform match filtering with RANSAC, but could be used to e.g. stitch images
    // the smaller the allowed reprojection error (here 15), the more matches are filtered 
    Mat Homog = Calib3d.findHomography(pts1Mat, pts2Mat, Calib3d.RANSAC, 15, outputMask, 2000, 0.995);

    // outputMask contains zeros and ones indicating which matches are filtered
    LinkedList<DMatch> better_matches = new LinkedList<DMatch>();
    for (int i = 0; i < good_matches.size(); i++) {
        if (outputMask.get(i, 0)[0] != 0.0) {
            better_matches.add(good_matches.get(i));
        }
    }

    // DRAWING OUTPUT
    Mat outputImg = new Mat();
    // this will draw all matches, works fine
    MatOfDMatch better_matches_mat = new MatOfDMatch();
    better_matches_mat.fromList(better_matches);
    Features2d.drawMatches(img1, keypoints1, img2, keypoints2, better_matches_mat, outputImg);

    // save image
    Imgcodecs.imwrite("result.jpg", outputImg);