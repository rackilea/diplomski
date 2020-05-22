@Column(name = "order_column")
private Integer orderColumn;

@PrePersist
@PreUpdate
private void updateOrderColumn() {
    // for changing order
    orderColumn = topic.getPosts().indexOf(this);
    // for persist
    if (orderColumn == -1)
        orderColumn = topic.getPosts().size();
}