import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static String longest(TreeNode tree) {
        if (tree == null) return null;

        var strs = new ArrayList<String>();
        strs.add(longest(tree.left));
        strs.add(longest(tree.right));
        strs.add((String)tree.value);
        return Collections.max(strs, 
            Comparator.comparing(s -> s == null ? 0 : s.length()));
    }

    public static void main(String[] args) {
        /*
             a
           /   \
         aaaa   aa
         /       \
        aaa    aaaaa   

        */
        var tree = new TreeNode<String>(
            "a",
            new TreeNode<String>(
                "aaaa",
                new TreeNode<String>("aaa", null, null),
                null
            ),
            new TreeNode<String>(
                "aa",
                null,
                new TreeNode<String>("aaaaa", null, null)
            )
        );
        System.out.println(longest(tree)); // => "aaaaa"
    }
}

class TreeNode<T> {
    public T value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(T value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}