public Builder<K, V> withCustomPartitioner(Class<? extends Partitioner> customPartitioner) {
    this.customPartitioner = customPartitioner;
    return this;
}

// Usage
builder
    .withCustomPartitioner(FooPartitioner.class)
    ...