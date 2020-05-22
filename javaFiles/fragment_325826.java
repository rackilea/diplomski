private void levelOrder(BinaryNode root) {
        if (root == null) {
            return;
        }

        Queue<BinaryNode> q = new LinkedList<>();

        // Pushing root node into the queue.
        q.add(root);

        // Executing loop till queue becomes
        // empty
        while (!q.isEmpty()) {

            BinaryNode curr = q.poll();
            System.out.print(curr.element + " ");

            // Pushing left child current node
                if (curr.left != null) {
                    q.add(curr.left);
                }

                // Pushing right child current node
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
    }