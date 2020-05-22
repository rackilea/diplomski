List<State> list = new ArrayList<State>();
State cur = new State(1,1);
list.add(cur);
cur = new State(2,3);
list.add(cur);
cur = new State(3,4);
list.add(cur);
for (State i : list)
    System.out.println(i.x + " " + i.y);


class State
{
    public final int x;
    public final int y;

    public State(int x, int y) 
    {
        this.x = x;
        this.y = y;
    }

}