package com.gati.dsalgo.string;

class BST {

    BSTNode root;

    public BST() {
        root = null;
    }

    void insertNames(int data, String name, double salary) {
        root = insertNames(root, data, name, salary);
    }

    BSTNode insertNames(BSTNode root, int data, String name, double salary) {
        if (root == null) {
            root = new BSTNode();
            root.setName(name);
            return root;
        }

        if (name.compareTo(root.getName()) < 0)
            root.setLeft(insertNames(root.getLeft(), data, name, salary));
        else if (name.compareTo(root.getName()) >= 0)
            root.setRight(insertNames(root.getRight(), data, name, salary));

        return root;
    }
}

public class Main1 {
    public static void main(String[] args) {

        BST alpha = new BST();
        alpha.insertNames(0, "Roy", 0);
        alpha.insertNames(0, "Joseph", 0);
        System.out.println("hello");
    }
}

class BSTNode {
    private String name;
    BSTNode left;
    BSTNode right;

    public void setName(String name) {
        this.name = name;

    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getRight() {

        return right;
    }

    public BSTNode getLeft() {
        return left;
    }

    public String getName() {

        return name;
    }

}