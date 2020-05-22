@Override
    @Cacheable(value = "contaCache", key = "#pageable.pageNumber")
    public Page<ContaGerencial> listPageable(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    @CachePut(value = "contaCache", key = "#conta.id")
    public ContaGerencial save(ContaGerencial conta) {
        return repository.save(conta);
    }

    @Override
    @CachePut(value = "contaCache", key = "#conta.id")
    public ContaGerencial update(ContaGerencial conta) {
        return repository.save(conta);
    }

    @CacheEvict(value = "contaCache", key = "#id")
        public void evictSingleCacheValue(String id) {
    }

    @CacheEvict(value = "contaCache", key = "#pageable.pageNumber")
        public void evictListPageable(Pageable pageable) {
    }