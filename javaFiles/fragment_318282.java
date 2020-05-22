Tree binaryTree = ...

  for( Instruction i : s ) {

      if( i.leaf == Tree.LEFT ) {
          tree.addLeft( i.value );
      } else if ( i.leaf == Tree.RIGHT ) {
           tree.addRight( i.value );
      }
  }