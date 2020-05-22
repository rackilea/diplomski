@Entity
   public class Order{

    @Id
    @GeneratedValue
    private Long order_id;

    @Column(name="order_date", nullable=false, length=15)
    private Date data;

    @Column(name="order_total", nullable=false, length=8)
    private double total;

    /* Relationships*/

    @Column(name="employee_id", nullable=false, length=8)
    private Long employee_id;

    @Column(name="customer_id", nullable=false, length=8)
    private Long customer_id;

    @ManyToMany(targetEntity=OrderItem.class, fetch=FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "order_order_item", joinColumns = { @JoinColumn(name = "cod_order") }, 
    inverseJoinColumns = { @JoinColumn(name = "cod_item") })
        public Set<OrderItem> setOrderItem = new HashSet<OrderItem>();


    public Long getId() {
       return order_id;
    }

    public void setId(Long order_id) {
       this.order_id= order_id;
    }

    public Date getOrderDate() {
       return order_date;
    }

    public void setOrderDate(Date order_date) {
       this.order_date = order_date;
    }

    public double getTotal() {
       return total;
    }

    public void setTotal(double total) {
       this.total = total;
    }

    public Long getFuncionario() {
       return cod_funcionario;
    }

    public void setEmployee(Long employee_id) {
       this.employee_id= employee_id;
    }

    public Long getCustomer() {
       return customer_id;
    }

    public void setCustomer(Long customer_id) {
       this.customer_id= customer_id;
    }

    public Set<OrderItem> getOrderItem() {
       return orderItem;
    }

    public void setOrderItem(Set<OrderItem> orderItem) {
       this.orderItem= orderItem;
    }

 }