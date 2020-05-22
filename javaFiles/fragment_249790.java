package br.com.ar.model.domain.Parent;

@Entity
public class Parent implements Serializable {

    private Integer id;

    private AbstractChild[] childArray;

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToMany
    @IndexColumn(name="CHILD_INDEX", nullable=false)
    @JoinColumn(name="PARENT_ID", nullable=false)
    @Cascade(CascadeType.SAVE_UPDATE)
    public AbstractChild[] getChildArray() {
        return childArray;
    }

    public void setChildArray(AbstractChild[] childArray) {
        this.childArray = childArray;
    }

}