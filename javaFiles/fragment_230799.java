@SQLDelete(sql="UPDATE customer SET deleted = '1' WHERE id = ?")
@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
//Filter added to retrieve only records that have not been soft deleted.
@Where(clause="deleted <> '1'")
    public Set getAppUsers() {
    return this.appUsers;
}