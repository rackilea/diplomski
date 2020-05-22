public class CalendarEntry {

...
@JsonIgnore
@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name = "service_charge_tier_id")
private ServiceChargeTier associatedServiceChargeTier;

...