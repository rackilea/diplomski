double [][][] trainingData = {
  {{0.0, 0.0, 1}, {1,0,0,0,0,0,0,0}},
  {{0.0, 0.1, 1}, {0,1,0,0,0,0,0,0}},
  {{0.0, 0.2, 1}, {0,0,1,0,0,0,0,0}},
  {{0.0, 0.3, 1}, {0,0,0,1,0,0,0,0}},
  {{0.0, 0.4, 1}, {0,0,0,0,1,0,0,0}},
  {{0.0, 0.5, 1}, {0,0,0,0,0,1,0,0}},
  {{0.0, 0.6, 1}, {0,0,0,0,0,0,1,0}},
  {{0.0, 0.7, 1}, {0,0,0,0,0,0,0,1}},
};

for(int i=0; i<8;i++) {
  // multiply the true inputs by 8 before the sin/cos in order
  // to increase the distance between points, and multiply the
  // resulting sin/cos by 2 for the same reason
  trainingData[i][0][0] = 2.0*Math.cos(trainingData[i][0][1]*8.0);
  trainingData[i][0][1] = 2.0*Math.sin(trainingData[i][0][1]*8.0);
}