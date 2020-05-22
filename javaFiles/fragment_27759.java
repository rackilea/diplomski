MBFImage currentFrame, prevFrame = video.getNextFrame();
for (currentFrame : video) {
    //do something with the frames

    //prepare for the next iteration
    prevFrame = currentFrame;
}