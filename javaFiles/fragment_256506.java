private final static int LEFT = 0;
private final static int RIGHT = 1;

private static class Node {
    private Node left,right;
    private boolean red;
    ...

    // any non-zero argument returns right
    Node link(int direction) {
        return (direction == LEFT) ? this.left : this.right;
    }
    // any non-zero argument sets right
    Node setLink(int direction, Node n) {
        if (direction == LEFT) this.left = n;
        else this.right = n;
        return n;
    }
}

boolean remove(int data) {
  if ( this.root != null ) {
    final Node head = new Node(-1, null, null); /* False tree root */
    Node cur, parent, grandpa; /* Helpers */
    Node found = null;  /* Found item */
    int dir = RIGHT;

    /* Set up helpers */
    cur = head;
    grandpa = parent = null;
    cur.setLink(RIGHT, this.root);

    /* Search and push a red down */
    while ( cur.link(dir) != null ) {
      int last = dir;

      /* Update helpers */
      grandpa = parent, parent = cur;
      cur = cur.link(dir);
      dir = cur.data < data ? RIGHT : LEFT;

      /* Save found node */
      if ( cur.data == data )
        found = cur;

      /* Push the red node down */
      if ( !is_red(cur) && !is_red(cur.link(dir)) ) {
        if ( is_red(cur.link(~dir)) )
          parent = parent.setLink(last, singleRotate(cur, dir));
        else if ( !is_red(cur.link(~dir)) ) {
          Node s = parent.link(~last);

          if ( s != null ) {
            if (!is_red(s.link(~last)) && !is_red(s.link(last))) {
              /* Color flip */
              parent.red = false;
              s.red = true;
              cur.red = true;
            }
            else {
              int dir2 = grandpa.link(RIGHT) == parent ? RIGHT : LEFT;

              if ( is_red(s.link(last)) )
                grandpa.setLink(dir2, doubleRotate(parent, last));
              else if ( is_red(s.link(~last)) )
                grandpa.setLink(dir2, singleRotate(parent, last));

              /* Ensure correct coloring */
              cur.red = grandpa.link(dir2).red = true;
              grandpa.link(dir2).link(LEFT).red = false;
              grandpa.link(dir2).link(RIGHT).red = false;
            }
          }
        }
      }
    }

    /* Replace and remove if found */
    if ( found != null ) {
      found.data = cur.data;
      parent.setLink(
        parent.link(RIGHT) == cur ? RIGHT : LEFT,
        cur.link(cur.link(LEFT) == null ? RIGHT : LEFT));
    }

    /* Update root and make it black */
    this.root = head.link(RIGHT);
    if ( this.root != null )
      this.root.red = false;
  }

  return true;
}