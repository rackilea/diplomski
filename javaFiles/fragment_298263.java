//For int [][][] arrays mentioned eariler
List<List<List<Integer>>> result = new ArrayList<>();
List<List<Integer>> current = new ArrayList<>();

solve(arrays, result, current, 0);
for (int i = 0; i < result.size(); i++) {
    System.out.println(result.get(i));
}


[[1, 2, 3], [4, 5], [6, 7, 8, 9]]
[[1, 2, 3], [300, 400], [6, 7, 8, 9]]
[[1, 2, 3], [500, 600, 700], [6, 7, 8, 9]]
[[100, 200], [4, 5], [6, 7, 8, 9]]
[[100, 200], [300, 400], [6, 7, 8, 9]]
[[100, 200], [500, 600, 700], [6, 7, 8, 9]]