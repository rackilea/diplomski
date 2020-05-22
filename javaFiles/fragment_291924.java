Mat img = imread("image.png",-1);

  //split channels, extract 3rd channel
  std::vector<Mat> channels;
  split(img, channels);

  // convert to white background and black foreground
  Mat black;
  bitwise_not(channels.at(3), black);


  imshow("image", black);
  waitKey(0);