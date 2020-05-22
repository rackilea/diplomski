@Transient
private Boolean isDefault;

@PostLoad
private void setDefault() {
this.isDefault=this.defaultAirportCode.equals(this.airportCode);
}