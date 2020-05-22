public class Student {
    private String name;
    private double totalScore;
    private ArrayList<Integer> scores;

    public Student(String name){
        this.name = name;
        scores = new ArrayList<Integer>();
    }

    public String getName() {
        return name;

    } public void addQuiz(int score){
        scores.add(score);
    }

    public double getTotalScore() {
        totalScore = 0;
        for(int score : scores){
            totalScore += score;
        }
        return totalScore;
    }

    public double getAverageScore(){
        return getTotalScore()/scores.size();
    }
}