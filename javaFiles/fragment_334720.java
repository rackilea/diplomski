public class Course {
    private String name;
    private List<Integer> homeWorkScores;
    public Course(String courseName){
        this.name = courseName;
        homeWorkScores = new ArrayList<Integers>();
    }

    public String getCourseName(){
        return name;
    }

    public boolean addHomeWorkScore(Integer score){
        return homeWorkScores.add(score);
    }
}