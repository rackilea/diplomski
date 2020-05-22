import cascading.pipe.Each;
import cascading.pipe.HashJoin;
import cascading.pipe.Pipe;
import cascading.pipe.joiner.LeftJoin;
import cascading.tuple.Fields;

public class StackHashJoinTest {
    public StackHashJoinTest() {
        Fields f1Input = new Fields("F1Input");
        Fields f2Input = new Fields("F2Input");
        Fields f1Join = new Fields("F1Join");
        Fields f2Join = new Fields("F2Join");

        Fields functionFields = new Fields("F1DecidingFactor", "F1Output", "F2DecidingFactor", "F2Output");

        // Large Pipe fields : 
        // F1DecidingFactor F1Input F2DecidingFactor F2Input
        Pipe largePipe = new Pipe("large-pipe");

        // Small Pipe 1 Fields : 
        // F1Join F1Result
        Pipe rhsOne = new Pipe("small-pipe-1");

        // Small Pipe 2 Fields : 
        // F2Join F2Result
        Pipe rhsTwo = new Pipe("small-pipe-2");

        // Joining first small pipe. 
        // Expected fields after join: 
        // F1DecidingFactor F1Input F2DecidingFactor F2Input F1Join F1Result
        Pipe resultsOne = new HashJoin(largePipe, f1Input, rhsOne, f1Join, new LeftJoin());

        // Joining second small pipe. 
        // Expected fields after join: 
        // F1DecidingFactor F1Input F2DecidingFactor F2Input F1Join F1Result F2Join F2Result
        Pipe resultsTwo = new HashJoin(resultsOne, f2Input, rhsTwo, f2Join, new LeftJoin());

        Pipe result = new Each(resultsTwo, functionFields, new TestFunction(), Fields.REPLACE);

        // result Pipe should have expected result
    }
}