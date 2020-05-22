@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "foo")
public class Foo {

    @Id
    @Column(name = "foo_id", nullable = false, unique = true, columnDefinition = "bigint(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fooId;
    private String name;
    @Column(name = "_deleted_")
    private Short deleted;

    @OneToMany(mappedBy = "foo")
    private List<Bar> bars;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "bar")
public class Bar {

    @Id
    @Column(name = "bar_id", nullable = false, unique = true, columnDefinition = "bigint(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long barId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foo_id")
    Foo foo;

    private String key;
    private String value;
    @Column(name = "_deleted_")
    private Short deleted;
}