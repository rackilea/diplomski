public class EdgeDifficultyWeight implements Comparable<EdgeDifficultyWeight> {

    private final Edge edge;
    private final int difficulty;

    public EdgeDifficultyWeight(Edge edge, int difficulty){
        this.edge = edge;
        this.difficulty = difficulty;
    }

    public int compareTo(EdgeDifficultyWeight arg) {
        return new CompareToBuilder()
                .append(arg.difficulty, this.difficulty)
                .append(arg.edge.getId(), this.edge.getId())
                .toComparison();
    }

}