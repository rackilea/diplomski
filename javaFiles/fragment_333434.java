private void verticalPrintTree(TreeNode root, int hd, HashMap<Integer, ArrayList<Integer>> hm) throws Exception {

        if (root == null) {
            return;
        }
        verticalPrintTree(root.left(), hd - 1, hm);
        if (hm.get(hd) == null) {
            System.out.println("initializing element for index " + hd + " element " + root.key()  );
            ArrayList list = new ArrayList();
            list.add(root.key());
            hm.put(hd, list);
        } else {
            System.out.println("adding element " + root.key() + " for index " + hd);
            hm.get(hd).add(root.key());
        }
        verticalPrintTree(root.right(), hd + 1, hm);

    }