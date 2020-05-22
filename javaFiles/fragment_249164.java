public class MyEntry implements Comparable<MyEntry> {

private double rank;
private double dist;
private int index;
private static int nextIndex = 0;

public MyEntry(double rank, double dist) {

    this.rank = rank;
    this.dist = dist;
    this.index = nextIndex++;

}