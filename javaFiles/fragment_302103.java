private MyEnum status;

public String getStatus() {
    return this.status.name();
}

public void setStatus(String status) {
    this.status = MyEnum.valueOf(status);
}