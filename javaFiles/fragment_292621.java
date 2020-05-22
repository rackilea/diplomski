@Component
public interface Coach{
  public String giveCoaching();
}

@Component
public TennisCoach implements Coach{
  @Override
  public String giveCoaching(){
    return "Teaching forhand";
  }
}

@Component
public CricketCoach implements Coach{
  @Override
  public String giveCoaching(){
    return "Teaching forbat";
  }
}