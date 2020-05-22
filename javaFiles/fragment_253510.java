public abstract class Progression<T> {
    protected T current;

    public Progression() { this( getInitial()); }
    protected abstract T getInitial();
    public Progression(T start) { current = start; }

    public T nextValue() {
         T answer = current;
         advance();
         return answer;
    }

    protected abstract void advance();

    public void printProgression(int n) {
        System.out.print(nextValue());
        for(int j = 1; j < n;j++)
            System.out.print(" " + nextValue());
        System.out.println();
    }
}