public static Node insert(Node root, int data) {

          // check if root == null then initialize root and return it
          if(root == null){ 
               return new Node(data);
          }
          //--------

          Node inserter = new Node(data);
          Node temp = root;
          while (true) {
              if (inserter.data <= temp.data) {
                  if (temp.left == null) {
                      temp.left = inserter;
                      break;
                  } else
                      temp = temp.left;

              } else {
                  if (temp.right == null) {
                      temp.right = inserter;
                      break;
                  } else
                      temp = temp.right;

              }
          }

          return root;
      }