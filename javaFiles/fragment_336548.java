public class ServiceAlarmConfEntity {
    @Id
    private Integer serviceId;

    @MapsId 
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    private Service service;

    ...
}