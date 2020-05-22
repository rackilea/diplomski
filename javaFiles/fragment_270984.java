@Entity
@Table(name = "singer")
public class SingerEntity {
    ...
    @OneToMany(mappedBy = "singer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AlbumEntity> albums;
    ...
}
@Entity
@Table(name = "album")
public class AlbumEntity {
    ...
    @ManyToOne
    @JoinColumn(name = "singer_id)
    private SingerEntity singer;
    ....
}