@Entity
public class Ride implements Serializable {
    ...
    @ManyToMany(mappedBy = "rides")
    private Map<Route, Town> routedTowns;
    ...
}

@Entity
public class Town implements Serializable {
    ...
    @ManyToMany
    private List<Ride> rides;
    @Embeddable
    private Route route;
    ...
}