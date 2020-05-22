private State selectedState; // +getter+setter
private SelectItem[] availableStateItems; // +getter (no setter necessary!)

@PostConstruct
public void init() {
    State[] availableStates = State.values();
    availableStateItems = new SelectItem[availableStates.length];

    for (int i = 0; i < availableStates.length; i++) {
        availableStateItems[i] = new SelectItem(availableStates[i]);
    }
}