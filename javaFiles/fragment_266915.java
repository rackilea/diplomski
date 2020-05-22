@Entity
@Table(name = "Donors")
@Access(AccessType.PROPERTY)
class Patient
{

    (...)
    private ObjectProperty<BloodType> bloodType = new SimpleObjectProperty<>();

    @Enumerated(EnumType.STRING)
    @Column(name="Blood_Type")
    public BloodType getBloodType() {
        return bloodType.get();
    }
    public void setBloodType(BloodType bloodType) {
        this.bloodType.set(bloodType);
    }

}