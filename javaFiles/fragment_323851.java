public void sort(final Comparator<? super T> dataComparator)
    {
        Collections.sort(this.children,
            new Comparator<Tree<T>>()
            {
                @Override
                public int compare(Tree<T> treeA, Tree<T> treeB)
                {
                    return dataComparator.compare(treeA.getData(), treeB.getData());
                }
            }
        );
        for(Tree<T> child: this.children)
        {
            child.sort(dataComparator);
        }
    }


void test()
{
    Tree<DataItem> tree = new Tree<>();

    tree.sort(new Comparator<DataItem>()
    {
        @Override
        public int compare(DataItem dataA, DataItem dataB)
        {
            return dataA.getName().compareTo(dataB.getName());
        }
    });

}