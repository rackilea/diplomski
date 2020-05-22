@Root(name="tTopGoalScorer", strict=false)
    public class TopGoalScorer {
        @Path("Body/TopGoalScorersResponse/TopGoalScorersResult/tTopGoalScorer/sName")
        @Element
        private String name;
    }