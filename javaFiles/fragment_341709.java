IplImage current = null;
IplImage flipped = null;

while (true) {
  current = grabber.grab();

  // Initialise the flipped image once the source image information
  // becomes available for the first time.
  if (flipped == null) {
    flipped = cvCreateImage(
      current.cvSize(), current.depth(), current.nChannels()
    );
  }

  cvFlip(current, flipped, 1);
}