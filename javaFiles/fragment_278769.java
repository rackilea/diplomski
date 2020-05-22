public class OracleSequenceChecker implements ISequenceChecker{
   OracleSequenceObject getSequence(){
    // some jdbc or similar call
    // to get SELECT SEQUENCE_NAME.NEXTVAL FROM DUAL
   }
}