GradeManager manager = new GradeManager();

while(condition) {
    int score = readScoreFromInput();
    manager.addScore(score);
}

double averageScore = manager.getAverage();
print(averageScore);