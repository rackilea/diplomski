DecaysToV2 convert( DecaysTo old )
{
    DecaysToV2Impl impl = new DecaysToV2Impl();
    impl.value = ...
    return impl;
}
static class DecaysToV2Impl implements DecaysToV2
{
    Particle[] value;
    public Particle[] value(){ return this.value; }
}