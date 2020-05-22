public class Solution {
    private void helper(List<String> res, String present, int left, int right, int n) {
        // When you've finished adding all parenthesis
        if (left == n and right == n) {
            res.push_back(str);
            return;
        }
        // You have left parenthesis available to add
        if (left < n) {
            helper(res, present + "(", left + 1, right, n);
        }
        // You can add right parenthesis only when you have more left parenthesis already added otherwise it won't be balanced
        if (left > right) {
            helper(res, present + ")", left, right + 1, n);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n == 0) {
            return res;
        }
        helper(res, "", 0, 0, n);
        return res;
    }
}