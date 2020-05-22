public Page<Entity> getAllBySpecification(
            Specification<Entity> specification, 
            int page, int size) {

        return dao.findAll(specification, createMyPageRequest(page, size));
    }

    private PageRequest createMyPageRequest(int page, int size) {
        return PageRequest.of(page, size, new Sort(Sort.Direction.DESC, "createdAt"));
    }