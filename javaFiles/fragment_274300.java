// Java program to print all the node to leaf path    
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* A binary tree node has data, pointer to left child
       and a pointer to right child */
class Color {

    private String color;
    private List<Color> list;

    public Color() {
        //default
    }

    public Color(String color) {
        this.color = color;
        list = new ArrayList();
    }

    public Color(String color, List<Color> list) {
        this.color = color;
        this.list = list;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void add(Color c) {
        this.list.add(c);
    }

    public void setList(List<Color> list) {
        this.list = list;
    }

    public String getColor() {
        return color;
    }

    public List<Color> getList() {
        return this.list;
    }
}

class ColorTree {
    Color root;

    /*Given a binary tree, print out all of its root-to-leaf
      paths, one per line. Uses a recursive helper to do
      the work.*/
    void printPaths(Color node) {
        String[] path = new String[1000];
        printPathsRecur(node, path, 0);
    }

    /* Recursive helper function -- given a node, and an array
       containing the path from the root node up to but not
       including this node, print out all the root-leaf paths.*/
    void printPathsRecur(Color node, String[] path, int pathLen) {
        if (node == null)
            return;

        /* append this node to the path array */
        path[pathLen] = node.getColor();
        pathLen++;
        printArray(path, pathLen);

        /* it's a leaf, so print the path that led to here  */
        if (node.getList() == null || node.getList().size() == 0) {
            //printArray(path, pathLen);
        } else {
            Iterator<Color> colorIter = node.getList().iterator();
            /* otherwise try subtrees */
            while (colorIter.hasNext()) {
                printPathsRecur(colorIter.next(), path, pathLen);
            }
        }
    }

    /* Utility function that prints out an array on a line. */
    void printArray(String[] names, int len) {
        int i;
        for (i = 0; i < len; i++) {
            System.out.print(names[i] + " ");
        }
        System.out.println();
    }


    private static Color convertJsonToColor(String input) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        return mapper.readValue(input, Color.class);
    }

    // driver program to test above functions
    public static void main(String[] args) throws IOException {

        String jsonInput = "{ \"color\": \"red\", \"list\": [{ \"color\": \"blue\", \"list\": [{ \"color\": \"yellow\" }, { \"color\": \"black\", \"list\": [{ \"color\": \"purple\" }, { \"color\": \"white\" }] }] }, { \"color\": \"green\", \"list\": [{ \"color\": \"pink\", \"list\": [{ \"color\": \"gray\" }, { \"color\": \"brown\" }] }] } ] }";

        ColorTree tree = new ColorTree();
        tree.root = convertJsonToColor(jsonInput);

        /* Let us test the built tree by printing Insorder traversal */
        tree.printPaths(tree.root);
    }
}