public class ProbabilityStrategy implements Strategy<String,Integer,Map<String, Integer>,GameFigures>{

        @Override
        public GameFigures computeMove(Map<String, Integer> c){
            Collection<Integer> values=c.values();
            Stream<Integer> stream=values.stream();
            Optional<Integer> userMaxFigureMoves=stream.max(Integer::compare);
            return null;
       }
}