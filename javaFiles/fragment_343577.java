class SameDirectionPathEvaluator implements PathEvaluator<Direction> {

   public Evaluation evaluate(Path path, BranchState<Direction> state) {
      if (path.length()==0) {
         return Evaluation.EXCLUDE_AND_CONTINUE;
      } else if (path.length()==1) {
         state.setState(getDirectionOfLastRelationship(path));
         return Evaluation.INCLUDE_AND_CONTINUE;
      } else {
         if (state.getState().equals(getDirectionOfLastRelationship(path)) {
            return Evaluation.INCLUDE_AND_CONTINUE;
         } else {
            return Evaluation.EXCLUDE_AND_PRUNE;
         }
      }
   }

   private Direction getDirectionOfLastRelationship(Path path) {
      assert path.length() > 0;
      Direction direction = Direction.INCOMING
      if (path.endNode().equals(path.lastRelationship().getEndNode()) {
        direction = Direction.OUTGOING;
      }
      return direction;
   }

}