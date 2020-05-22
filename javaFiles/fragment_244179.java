TypeB b = new TypeB();

TypeA a = new TypeA();
a.setBs(ListUtils.createList(b));
b.setA(a);   

this.typeBDao.save(b);
this.typeADao.save(a);