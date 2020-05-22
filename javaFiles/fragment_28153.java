protected Integer id_sample;
protected Integer test;

@Id
@Column(name="id_sample")
public Integer getId_sample() {
    return id_sample;
}
public void setId_gem_import(Integer id_sample) {
    this.id_sample= id_sample;
}

@Id
@Column(name="test")
public Integer getTest() {
    return test;
}
public void setTest(Integer test) {
    this.test= test;
}