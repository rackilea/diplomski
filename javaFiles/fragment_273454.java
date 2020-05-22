private static final class Pencil {
    private final int id;
    private Pencil(int id) { this.id = id; }
    @Override
    public String toString() { return "p" + id; }
}

public static void main(String[] args) {
    Pencil p1 = new Pencil(1);
    Pencil p2 = new Pencil(2);
    Pencil p3 = new Pencil(3);
    Pencil p4 = new Pencil(4);
    Pencil p5 = new Pencil(5);
    List<Set<Pencil>> matches = new ArrayList<>();
    matches.add(new HashSet<>(Arrays.asList(p1, p2, p5)));     // First eraser only fits these 3 pencils.
    matches.add(new HashSet<>(Arrays.asList(p3, p4)));         // Second eraser only fits these 2 pencils.
    matches.add(new HashSet<>(Arrays.asList(p3, p5)));         // etc
    matches.add(new HashSet<>(Arrays.asList(p1, p2, p4)));
    matches.add(new HashSet<>(Arrays.asList(p1, p5)));
    System.out.println(allocate(matches));                     // prints [p2, p4, p3, p1, p5]
}

// Returns null if no solution can be found.
private static List<Pencil> allocate(List<Set<Pencil>> matches) {
    return allocate(matches, new ArrayList<>());
}

private static List<Pencil> allocate(List<Set<Pencil>> matches, List<Pencil> solution) {
    int size = solution.size();
    if (matches.size() == size)
        return solution;
    for (Pencil pencil : matches.get(size)) {
        if (solution.contains(pencil))
            continue;
        List<Pencil> copy = new ArrayList<>(solution);
        copy.add(pencil);
        List<Pencil> result = allocate(matches, copy);
        if (result != null)
            return result;
    }
    return null;
}