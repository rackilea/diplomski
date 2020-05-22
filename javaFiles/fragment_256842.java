@Entity
@Table(name = "traffic_jam", schema = "public", catalog = "dwh")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrafficJamEntity {

    @Id
    @Column(name = "traffic_jam_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "traffic_jam_seq")
    @SequenceGenerator(name = "traffic_jam_seq", sequenceName = "traffic_jam_id_sequence", allocationSize = 1)
    private long trafficJamId;

    @OneToMany(mappedBy = "trafficJamEntity", cascade = CascadeType.PERSIST)
    @Builder.Default
    private Set<DisturbanceCourseEntity> disturbanceCourseEntitySet = new LinkedHashSet<>();
}