// decode and return the grabbed video frame
cap.retrieve(matFrame);

// *** START
if (firstFrame) {
    firstFrame = false;
    continue;
}
// *** End

// if the frame is valid (not end of video for example)
if (!(matFrame.empty()))