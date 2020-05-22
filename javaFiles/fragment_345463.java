public class IntervalTreeAVL<T>{
    private static class TreeNode<T>{
        private T low;
        private T high;
        private TreeNode<T> left;
        private TreeNode<T> right;
        private T max;
        private int height;
        private TreeNode(T l, T h){
            this.low=l;
            this.high=h;
            this.max=high;
            this.height=1;
        }
    }
    private TreeNode<T> root;
    public void insert(T l, T h){
        root=insert(root, l, h);
    }
    private TreeNode<T> insert(TreeNode<T> node, T l, T h){
        if(node==null){
            return new TreeNode<T>(l, h);
        }
        else{
            int k=((Comparable)node.low).compareTo(l);
            if(k>0){
                node.left=insert(node.left, l, h);
            }
            else{
                node.right=insert(node.right, l, h);
            }
            node.height=Math.max(height(node.left), height(node.right))+1;
            node.max=findMax(node);
            int hd = heightDiff(node);
            if(hd<-1){
                int kk=heightDiff(node.right);
                if(kk>0){
                    node.right=rightRotate(node.right);
                    return leftRotate(node);
                }
                else{
                    return leftRotate(node);
                }
            }
            else if(hd>1){
                if(heightDiff(node.left)<0){
                    node.left = leftRotate(node.left);
                    return rightRotate(node);
                }
                else{
                    return rightRotate(node);
                } 
            }
            else;
        }
        return node;
    }
    private TreeNode<T> leftRotate(TreeNode<T> n){
        TreeNode<T> r =  n.right;
        n.right = r.left;
        r.left=n;
        n.height=Math.max(height(n.left), height(n.right))+1;
        r.height=Math.max(height(r.left), height(r.right))+1;
        n.max=findMax(n);
        r.max=findMax(r);
        return r;
    }
    private TreeNode<T> rightRotate(TreeNode<T> n){
        TreeNode<T> r =  n.left;
        n.left = r.right;
        r.right=n;
        n.height=Math.max(height(n.left), height(n.right))+1;
        r.height=Math.max(height(r.left), height(r.right))+1;
        n.max=findMax(n);
        r.max=findMax(r);
        return r;
    }
    private int heightDiff(TreeNode<T> a){
        if(a==null){
            return 0;
        }
        return height(a.left)-height(a.right);
    }
    private int height(TreeNode<T> a){
        if(a==null){
            return 0;
        }
        return a.height;
    }
    private T findMax(TreeNode<T> n){
        if(n.left==null && n.right==null){
            return n.max;
        }
        if(n.left==null){
            if(((Comparable)n.right.max).compareTo(n.max)>0){
                return n.right.max;
            }
            else{
                return n.max;
            }
        }
        if(n.right==null){
           if(((Comparable)n.left.max).compareTo(n.max)>0){
                return n.left.max;
            }
            else{
                return n.max;
            } 
        }
        Comparable c1 = (Comparable)n.left.max;
        Comparable c2 = (Comparable)n.right.max;
        Comparable c3 = (Comparable)n.max;
        T max=null;
        if(c1.compareTo(c2)<0){
            max=n.right.max;
        }
        else{
            max=n.left.max;
        }
        if(c3.compareTo((Comparable)max)>0){
            max=n.max;
        }
        return max;
    }


TreeNode intervalSearch(T t1){
        TreeNode<T> t = root;
        while(t!=null && !isInside(t, t1)){
            if(t.left!=null){
                    if(((Comparable)t.left.max).compareTo(t1)>0){
                    t=t.left;
                }
                else{
                    t=t.right;
                }
            }
            else{
                t=t.right;
            }
        }
        return t;
    }
    private boolean isInside(TreeNode<T> node, T t){
        Comparable cLow=(Comparable)node.low;
        Comparable cHigh=(Comparable)node.high;
        int i = cLow.compareTo(t);
        int j = cHigh.compareTo(t);
        if(i<=0 && j>=0){
            return true;
        }
        return false;
    }
}