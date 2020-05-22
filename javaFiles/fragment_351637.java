public static <MyType> int calculateHeight(MyTreeNode<MyType> r){
    if (r ==null)
        return 0;
    if (r.children.size()==0)
        return 1;
    int count=0;
    List<Integer> heights = new ArrayList<>(); 
    for (MyTreeNode<MyType> e : r.children) {
        count = calculateHeight(e)+1;           
        heights.add(count);
    }
    return max(heights);        
}