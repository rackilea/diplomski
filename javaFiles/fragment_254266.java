class Solution {
    List<Integer> colsUsed;
    List<Integer> leftDiagsUsed;
    List<Integer> rightDiagsUsed;
    List<List<String>> solutions;

    public List<List<String>> solveNQueens(int n) {
        // [...]
        solutions = new ArrayList<List<String>>();