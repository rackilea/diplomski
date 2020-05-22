public class Result {
  private String type;
  private String email;
  private int numPassed;
  private Double total;

  public Result(String type, String email, boolean approved) {
      total = 1.0;
      this.type = type;
      this.email = email;
      this.numPassed = approved ? 1 : 0;
  }

  public void increase(boolean examResult){
      total++;
      if(examResult){
          numPassed++;
      }
  }

  public boolean isApproved(){
      return numPassed >= total / 2d;
  }

  public String getFraction(){
    return numPassed + "/" + total.intValue();
  }
}