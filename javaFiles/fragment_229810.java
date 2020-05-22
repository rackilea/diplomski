@Override
    public Page<InsuranceRenew> getRenew(@NonNull PageDto page, @NonNull C2Criteria criteria) {
        Pageable pageable = PageRequest.of(page.getPage(), page.getSize(), new Sort(page.getSort(), page.getOrderBy()));
        InsuranceRenewSpecification specification = InsuranceRenewSpecification.of(criteria);
        return this.renewRepository.findAll(specification, pageable);
    }