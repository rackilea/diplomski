private TAvailabilityState availablilityState = null; // or a more suiteable initial value
@Override
public void NetworkPathStateChanged(TAvailabilityState availabilityState) {
    this.availabilityState = availabilityState;
    Log.d("SipNetworkPath", "SipNetworkPath - Do networkpathstate changed!");
}