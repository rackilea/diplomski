UnitOfWork uow0 = new UnitOfWork("0");
UnitOfWork uow1 = new UnitOfWork("1");
UnitOfWork uow2 = new UnitOfWork("2");

for(int i = 0; i < 5; i++){
    executor.submit(uow0);
    executor.submit(uow1);
    executor.submit(uow2);
}