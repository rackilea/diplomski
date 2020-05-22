int noOfComp = 0;
int prevNoOfComp = 0;

void draw() {

    float rectPos = 0;
    frameRate(10);
    background(255);
    for (int j = 0; j < totalNum; j++) {
        stroke(220);
        if (noOfComp != prevNoOfComp && (j==i-1 || j==i)) {
            fill(255, 0, 0);
        } else {
            fill(127);
        }
        rect(rectPos, height - values[j], width / totalNum, values[j]);
        rectPos += width / totalNum;
    }
    textSize(12);
    text("No. Of Comparisons: ", 15, 40);
    text(noOfComp, 80, 60);

    prevNoOfComp = noOfComp;
    bubbleSort();
}