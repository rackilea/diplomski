interface Tree<N extends Node<N>,
               T extends Tree<N, T>> { ... }

interface SearchableTree<N extends SearchableNode<N>,
                         S extends Searcher<N>,
                         T extends SearchableTree<N, S, T>>
    extends Tree<N, T> { ... }