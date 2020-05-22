...
ENUM_A  (1, "test1", TestADto::new),
ENUM_B  (2, "test2", TestBDto::new),
ENUM_C  (3, "test3", TestCDto::new);

private Supplier<Dto> supplierDto;

TestEnum(int i, String name, Supplier<Dto> supplierDTO){
    this.supplierDto = supplierDTO;
    ...
}
...