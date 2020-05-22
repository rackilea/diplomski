class FirstNode
{
    private TrNode node;

    public void setNode(final TrNode node)
    {
        if (this.node == null)
        {
            this.node = node;
        }
    }

    public Optional<TrNode> first()
    {
        return Optional.ofNullable(node);
    }
}

Stream.of(b1, b2, b3)
    .map(TrNode::normalize)
    .filter(Objects::nonNull)
    .collect(
        Collector.of(
            FirstNode::new,
            FirstNode::setNode,
            (node, node2) -> node
        )
    )
    .first()
    .ifPresent(it -> {
        resp.m1 = it.m1;
        resp.m2 = it.m2;
        resp.m3 = it.m3;
    });