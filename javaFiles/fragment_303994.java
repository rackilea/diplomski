if (root.value < node.value) {
                if (node.right == null) {
                    root.right = new Node(node.value);
                    log.info("node.right.value:" + root.right.value);
                }
            } else { //<--- delete the right(}) curly brace.
                     // because your else clause is in the wrong place
                log.info("insert(node.right):" + root.right.value);
                insert(root.right);
            }
        }