private Bar bar;

@OneToOne(fetch=FetchType.LAZY, optional=false)
public Bar getBar() {
    return this.bar;
}