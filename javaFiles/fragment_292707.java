Specification<CustomerEntity> joins = (customer, query, cb) ->  {

    Join<CustomerEntity, CustomerItemEntity> items = customer.join("items");
    Join<CustomerItemEntity, DocumentEntity> documents = items.join("documents");

    // Ascending order by 'Document.itemNumber'
    query.orderBy(cb.asc(documents.get("itemNumber")));

    return cb.and( 
            customer.equal(customer.get("customerNumber", customerNumber)),
            items.equal(items.get("itemNumber", itemNumber)), 
            documents.equal(documents.get("validDate", validDate))
    );
};

Page<CustomerEntity> customerPage = CustomerRepo.findAll(joins, new PageRequest(0, 2));