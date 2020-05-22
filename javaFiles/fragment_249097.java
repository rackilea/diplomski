@Entity
@Table(name = "DETAIL_TAB")
public class Detail {
    ...
    @MapsId("masterId")
    @ManyToOne
    @JoinColumns({
        @JoinColumn(
            name                 = "MASTER_ID",
            referencedColumnName = "MASTER_ID",
            nullable             = false
        )
    })
    private Master master;
}