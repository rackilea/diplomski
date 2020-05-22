public class Feedback {

    private Satisfaction satisfaction;

    private String comment;

    public Satisfaction getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(Satisfaction satisfaction) {
        this.satisfaction = satisfaction;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Feedback[satisfaction=" + satisfaction.name() + ", comment=" + comment + "]";
    }

    public static enum Satisfaction {

        SATISFIED, NOT_SATISFIED

    }

}