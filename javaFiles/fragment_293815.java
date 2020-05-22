public Collection<V>  getSuccessors(V vertex)
    {
        if (!containsVertex(vertex))
            return null;
        return Collections.unmodifiableCollection(getSuccs_internal(vertex));
    }