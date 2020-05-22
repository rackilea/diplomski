@OneToMany(fetch=FetchType.LAZY)
@JoinTable(name="join_table", 
    joinColumns={@JoinColumn(name="a_id")},
    inverseJoinColumns={@JoinColumn(name="b_id")}
)
@Cascade(org.hibernate.annotations.CascadeType.ALL)
public Set<B> getBs() {
    return bs;
}