@Entity
@Table(name = "disturbance_course", schema = "public", catalog = "dwh")
@IdClass(DisturbanceCourseEntityPK.class)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DisturbanceCourseEntity {

    @ManyToOne
    @Id
    @JoinColumn(name = "traffic_jam_id")
    private TrafficJamEntity trafficJamEntity;

}