public void sort(final Comparator<? super T> dataComparator)
    {
        Collections.sort(this.children, 
            Comparator.comparing(Tree::getData, dataComparator));

        for(Tree<T> child: this.children)
        {
            child.sort(dataComparator);
        }
    }


void test()
{
    Tree<DataItem> tree = new Tree<>();

    tree.sort( Comparator.comparing(DataItem::getName) );
}