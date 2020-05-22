@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchOutcomeWrapper {

public MatchOutcome matchOutcome;

public MatchOutcomeWrapper(@JsonProperty("MATCH_OUTCOME") MatchOutcome matchOutcome) {
    this.matchOutcome = matchOutcome;
}

public MatchOutcome getMatchOutcome() {
    return matchOutcome;
}

public String toString() {

    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
            .append("matchOutcome", matchOutcome)
            .toString();
}
}