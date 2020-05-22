@Transactional
public void method1(){
    this.updateM1Service();
    this.getDataService();
}

@Transactional (propagation = Propagation.REQUIRES_NEW)
public void updateM1Service(){
    dao.updateM1();
}

@Transactional
public void getDataService(){
    dao.getData();
}