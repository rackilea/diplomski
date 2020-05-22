public class ArrayExpander implements PathExpander {

private String[] sequence;

public ArrayExpander(String[] sequence)
{
    this.sequence = sequence;
}

public Iterable<Relationship> expand(Path path, BranchState state){
    if(path.endNode().getProperty("n").equals(sequence[path.length()]){
      return path.endNode().getRelationships(Direction.INCOMING);
    } else {
      return path.endNode().getRelationships(DynamicRelationshipType.withName("IDONTEXIST"));
     }

}

public ArrayExpander reverse()
{
    return new ArrayExpander(Collections.reverse(Arrays.asList(sequence)));
}
}