public class MatchesCorrespondence<A> extends Correspondence<A, String> {
     @Override
     public boolean compare(@Nullable A actual, @Nullable String expected) {
         return actual != null && actual.toString().matches(expected);
     }

     // other overrides
}