Specification<CustomerEntity> joins = (customer, query, cb) ->  {
    // from CustomerEntity c
    // join c.items i
    Join<CustomerEntity, CustomerItemEntity> items = customer.join("items");

    // join i.documents d
    Join<CustomerItemEntity, DocumentEntity> documents = items.join("documents");

    // // where c.customerNumber = ?1 and i.itemNumber = ?2 and d.validDate = ?3 
    return cb.and( 
            customer.equal(customer.get("customerNumber", customerNumber)),
            items.equal(items.get("itemNumber", itemNumber)), 
            documents.equal(documents.get("validDate", validDate))
    );
};

// sort by c.customerNumber asc
PageRequest pageRequest = new PageRequest(0, 2, new Sort(Sort.Direction.ASC, "customerNumber"));

Page<CustomerEntity> customerPage = CustomerRepo.findAll(joins, pageRequest);