private final List<VesselCalculation> vesselCalculations = new ArrayList<>();
public Solution(ArrayList<Vessel> vessels) {
    for (Vessel vessel : vessels) {
         vesselCalculations.add(new VesselCalculation(vessel));
    }
    generateSolution();
}