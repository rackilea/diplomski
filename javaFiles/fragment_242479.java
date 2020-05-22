public static class BoardState {

    int positions[];

    private int priority;

    /**
     * Get the value of priority
     *
     * @return the value of priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Set the value of priority
     *
     * @param priority new value of priority
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    private int distFromGoal;

    /**
     * Get the value of distFromGoal
     *
     * @return the value of distFromGoal
     */
    public int getDistFromGoal() {
        return distFromGoal;
    }

    /**
     * Set the value of distFromGoal
     *
     * @param distFromGoal new value of distFromGoal
     */
    public void setDistFromGoal(int distFromGoal) {
        this.distFromGoal = distFromGoal;
    }

    private BoardState goal;

    /**
     * Get the value of goal
     *
     * @return the value of goal
     */
    public BoardState getGoal() {
        return goal;
    }

    /**
     * Set the value of goal
     *
     * @param goal new value of goal
     */
    public void setGoal(BoardState goal) {
        this.goal = goal;
    }

    private int depth;

    /**
     * Get the value of depth
     *
     * @return the value of depth
     */
    public int getDepth() {
        return depth;
    }

    /**
     * Set the value of depth
     *
     * @param depth new value of depth
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }

    private BoardState prev;

    /**
     * Get the value of prev
     *
     * @return the value of prev
     */
    public BoardState getPrev() {
        return prev;
    }

    /**
     * Set the value of prev
     *
     * @param prev new value of prev
     */
    public void setPrev(BoardState prev) {
        this.prev = prev;
    }

    public BoardState(BoardState other) {
        this.positions = new int[9];
        System.arraycopy(other.positions, 0, this.positions, 0, positions.length);
        this.depth = other.depth + 1;
        this.goal = other.goal;
        this.prev = other;
    }

    private BoardState() {

    }

    public static BoardState goal() {
        List<Integer> l = new ArrayList<Integer>();
        IntStream.range(0, 9).forEach(i -> l.add(i));
        BoardState r = new BoardState();
        r.positions = new int[9];
        Arrays.setAll(r.positions, i -> l.get(i).intValue());
        return r;
    }

    public static BoardState random() {
        List<Integer> l = new ArrayList<Integer>();
        IntStream.range(0, 9).forEach(i -> l.add(i));
        Collections.shuffle(l);
        BoardState r = new BoardState();
        r.positions = new int[9];
        Arrays.setAll(r.positions, i -> l.get(i).intValue());
        return r;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Arrays.hashCode(this.positions);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BoardState other = (BoardState) obj;
        if (!Arrays.equals(this.positions, other.positions)) {
            return false;
        }
        return true;
    }

    int valueAt(int r, int c) {
        int pos = r * 3 + c;
        for (int i = 0; i < positions.length; i++) {
            if (pos == positions[i]) {
                return i;
            }
        }
        throw new RuntimeException("invalid board or position");
    }

    void print() {
        System.out.println("depth = " + depth);
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                System.out.print(this.valueAt(r, c) + "\t");
            }
            System.out.println("");
        }

    }

    int distance(BoardState other) {
        int dist = 0;
        for (int i = 0; i < positions.length; i++) {
            int c0 = this.positions[i] % 3;
            int r0 = this.positions[i] / 3;
            int c1 = other.positions[i] % 3;
            int r1 = other.positions[i] / 3;
            dist += Math.abs(r0 - r1) + Math.abs(c0 - c1);
        }
        return dist;
    }

    public List<BoardState> moves() {
        List<BoardState> newList = new ArrayList<>();
        int r0 = this.positions[0] / 3;
        int c0 = this.positions[0] % 3;
        if (r0 > 0) {
            BoardState up = new BoardState(this);
            up.positions[0] = (r0 - 1) * 3 + c0;
            for (int i = 1; i < 9; i++) {
                if (this.positions[i] == up.positions[0]) {
                    up.positions[i] = this.positions[0];
                    break;
                }
            }
            newList.add(up);
        }
        if (r0 < 2) {
            BoardState down = new BoardState(this);
            down.positions[0] = (r0 + 1) * 3 + c0;
            for (int i = 1; i < 9; i++) {
                if (this.positions[i] == down.positions[0]) {
                    down.positions[i] = this.positions[0];
                    break;
                }
            }
            newList.add(down);
        }
        if (c0 > 0) {
            BoardState left = new BoardState(this);
            left.positions[0] = r0 * 3 + (c0 - 1);
            for (int i = 1; i < 9; i++) {
                if (this.positions[i] == left.positions[0]) {
                    left.positions[i] = this.positions[0];
                    break;
                }
            }
            newList.add(left);
        }
        if (c0 < 2) {
            BoardState right = new BoardState(this);
            right.positions[0] = r0 * 3 + (c0 + 1);
            for (int i = 1; i < 9; i++) {
                if (this.positions[i] == right.positions[0]) {
                    right.positions[i] = this.positions[0];
                    break;
                }
            }
            newList.add(right);
        }
        for (BoardState move : newList) {
            move.setDistFromGoal(move.distance(goal));
            move.setPriority(move.distFromGoal + move.depth);
        }
        return newList;
    }
}