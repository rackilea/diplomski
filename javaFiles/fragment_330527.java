void draw(){
    background(255);
    axes();

    //Draw Points
    for(int j=0;j<allData.length;j+=1){
        float[] point = allData[j];
        advancedPoint(point[0],point[1],color(181, 16, 32),10);
    }

    //Gradient descend, thats the confusing part...
    if(i<10000){
        i += 1;
        float dcost_dreg = 0;
        float dcost_dtar = 0;
        for(int j=0;j<allData.length;j+=1){
            float[] point = allData[j];
            float yTarget = point[1];
            float yRegression = w1*point[0] + b;
            dcost_dreg += (yTarget-yRegression);
            dcost_dtar += (yTarget-yRegression)/point[0];
        }
        w1 += learningRate * (dcost_dtar/allData.length); 
        b  += learningRate * (dcost_dreg/allData.length);
    }

    //Draw Regression
    linearPoints(w1, b);
}