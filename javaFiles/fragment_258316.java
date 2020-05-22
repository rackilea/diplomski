public Page<Entity> getAllBySpecification(
            Specification<Entity> specification, 
            Pageable pageable) {

        PageRequest pageRequest = createMyPageRequest(
                pageable.getPageNumber(), 
                pageable.getPageSize());

        return dao.findAll(specification, pageRequest);
    }