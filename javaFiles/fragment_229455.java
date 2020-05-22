if (pool instanceof UnboundedPool) {
    this.poolAccessor = pool.createPoolAccessor(null, null);
} else {
    this.poolAccessor = pool.createPoolAccessor(new Participant(),
        SizeOfPolicyConfiguration.resolveMaxDepth(cache),
        SizeOfPolicyConfiguration.resolveBehavior(cache).equals(SizeOfPolicyConfiguration.MaxDepthExceededBehavior.ABORT));
}