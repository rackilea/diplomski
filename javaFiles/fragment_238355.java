interface Instruction {}
class DerivedInstruction implements Instruction {}

Set<? extends Instruction> parse(String rawData){
    return new HashSet<DerivedInstruction>();
}