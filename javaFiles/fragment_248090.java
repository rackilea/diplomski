@Override
default Page<Person> findAll(Pageable pageable) {
    return findAllBy(applyDefaultOrder(pageable));
}

Page<Person> findAllBy(Pageable pageable);

default Pageable applyDefaultOrder(Pageable pageable) {
    if (pageable.getSort().isUnsorted()) {
        Sort defaultSort = Sort.by("lastname").ascending();
        pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), defaultSort);
    }
    return pageable;
}