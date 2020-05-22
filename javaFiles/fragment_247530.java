int numOfTries;
while (!isFinishStage && numOfTries < 3) {
    numOfTries++;
    if (tryPattern(s, "imgs/img1.png", 0.9f) ||
        tryPattern(s, "imgs/img2", 0.5f)) {
        isFinishStage = true;
    } else {
        // Note that the third "attempt" is inconsistent with
        // the others because you don't set isFinishedStage.
        tryPattern(s, "imgs/img3", 1.0f)
    }
}

private boolean tryPattern(SomeClass s, String path, float similarity) {
    try {
        Pattern temp = new Pattern(path);
        if (similarity != 1.0f) {
            temp = temp.similar(similarity);
        }
        s.wait(temp, 1);
        s.find(temp);
        s.hover(temp);
        return true;
    } catch (FindFailed ff) {
        return false;
    }
}