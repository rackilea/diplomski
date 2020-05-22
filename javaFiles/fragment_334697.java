int n = 10;

Pageable pageCount = new PageRequest(0, n);

List<TxnEntity> txnEntities = txnDAO
        .findByAccountEntityOrderByIdDesc(accountEntity,pageCount);