class MeasurePoint {
  int temperature;  // For example
  int windSpeed;

  MeasurePoint(int a, int b) {
    temperature = a;
    windSpeed = b;
  }
}

MeasurePoint[][] map = new MeasurePoint[rows][cols];

for(int i = 0; i < rows; i++) {
    for(int j = 0; j < cols; j++) {
      map[i][j] = new MeasurePoint(value1, value2);
    }
}