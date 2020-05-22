public class Receipt {

    private List<Feedback> feedbacks = new ArrayList<>();

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    @Override
    public String toString() {
        return "Receipt[feedbacks=" + feedbacks + "]";
    }

}