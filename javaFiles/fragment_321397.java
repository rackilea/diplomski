@Embeddable
@Data
class AvailableValues {
    @ManyToMany
    @JoinTable(name = "CAR_WHEELS",
            joinColumns = @JoinColumn(name = "CAR_FK"),
            inverseJoinColumns = @JoinColumn(name = "WHEEL_FK"))
    Set<Wheel> wheels;
}