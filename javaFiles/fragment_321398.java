@Embedded
@AssociationOverride(name = "wheels",
        joinTable = @JoinTable(name = "MY_CAR_WHEELS",
                joinColumns = @JoinColumn(name = "MY_CAR_FK"),
                inverseJoinColumns = @JoinColumn(name = "MY_WHEEL_FK")
        )
)
AvailableValues availableValues;