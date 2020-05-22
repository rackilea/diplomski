public class Profile {
  Profile profile
  @JsonUnwrapped
  Interests interests
}


public class Interests {
  HashMap<String,InterestMetric> interests = ...
}