import cascading.operation.Insert;
import cascading.pipe.Each;
import cascading.pipe.HashJoin;
import cascading.pipe.Pipe;
import cascading.pipe.assembly.Discard;
import cascading.pipe.joiner.LeftJoin;
import cascading.tuple.Fields;

public class StackHashJoinTestOption2 {
    public StackHashJoinTestOption2() {
        Fields f1Input = new Fields("F1Input");
        Fields f2Input = new Fields("F2Input");
        Fields f1Join = new Fields("F1Join");
        Fields f2Join = new Fields("F2Join");

        Fields f1DecidingFactor = new Fields("F1DecidingFactor");
        Fields f2DecidingFactor = new Fields("F2DecidingFactor");
        Fields f1DecidingFactorRhs = new Fields("F1DecidingFactor_RHS");
        Fields f2DecidingFactorRhs = new Fields("F2DecidingFactor_RHS");

        Fields lhsJoinerOne = f1DecidingFactor.append(f1Input);
        Fields lhsJoinerTwo = f2DecidingFactor.append(f2Input);

        Fields rhsJoinerOne = f1DecidingFactorRhs.append(f1Join);
        Fields rhsJoinerTwo = f2DecidingFactorRhs.append(f2Join);

        Fields functionFields = new Fields("F1DecidingFactor", "F1Output", "F2DecidingFactor", "F2Output");

        // Large Pipe fields : 
        // F1DecidingFactor F1Input F2DecidingFactor F2Input
        Pipe largePipe = new Pipe("large-pipe");

        // Small Pipe 1 Fields : 
        // F1Join F1Result
        Pipe rhsOne = new Pipe("small-pipe-1");

        // New field to small pipe. Expected Fields:
        // F1Join F1Result F1DecidingFactor_RHS
        rhsOne = new Each(rhsOne, new Insert(f1DecidingFactorRhs, "Yes"), Fields.ALL);

        // Small Pipe 2 Fields : 
        // F2Join F2Result
        Pipe rhsTwo = new Pipe("small-pipe-2");

        // New field to small pipe. Expected Fields:
        // F2Join F2Result F2DecidingFactor_RHS
        rhsTwo = new Each(rhsTwo, new Insert(f1DecidingFactorRhs, "Yes"), Fields.ALL);

        // Joining first small pipe. Expected fields after join: 
        // F1DecidingFactor F1Input F2DecidingFactor F2Input F1Join F1Result F1DecidingFactor_RHS
        Pipe resultsOne = new HashJoin(largePipe, lhsJoinerOne, rhsOne, rhsJoinerOne, new LeftJoin());

        // Joining second small pipe. Expected fields after join: 
        // F1DecidingFactor F1Input F2DecidingFactor F2Input F1Join F1Result F1DecidingFactor_RHS F2Join F2Result F2DecidingFactor_RHS
        Pipe resultsTwo = new HashJoin(resultsOne, lhsJoinerTwo, rhsTwo, rhsJoinerTwo, new LeftJoin());

        Pipe result = new Each(resultsTwo, functionFields, new TestFunction(), Fields.REPLACE);

        result = new Discard(result, f1DecidingFactorRhs);
        result = new Discard(result, f2DecidingFactorRhs);

        // result Pipe should have expected result
    }
}