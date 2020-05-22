abstract class Tree { .... }
class Leave extends Tree { int number; ... }
class Expr  extends Tree { Tree left, right; String operation;  .... }

public Tree makeBinaryTree(expr):
   element = next element in expr
   if element is a number:
      return new Leave(element)
   else: // element is an operator
      left = makeBinaryTree(expr)
      right = makeBinaryTree(expr)
   return new Expr(left, right, element)