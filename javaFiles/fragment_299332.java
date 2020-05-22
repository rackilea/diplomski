public String update() {
    try {
        return update2();
    } catch (Exception e) {
        return "Exception in update()";
    }
}

@Transactional(rollbackFor = Exception.class)
public String update2() throws Exception {

    List<Employee> l = repo.findAll();
        for(int i=0 ; i<2 ; i++) {
            if(i==0) {
                l.get(i).setUsername("duplicate_value");
            } else {
                l.get(i).setUsername("unique_value");
            }
            repo.save(l.get(i));
        }
        return "success";
}