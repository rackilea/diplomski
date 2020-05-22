for (int j = 0; j < totalNum; j++) {
    stroke(220);
    if (j==i-1 || j==i) {
        fill(255, 0, 0);
    } else {
        fill(127);
    }
    rect(rectPos, height - values[j], width / totalNum, values[j]);
    rectPos += width / totalNum;
}