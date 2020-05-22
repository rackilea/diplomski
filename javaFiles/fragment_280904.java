public static Map<String, Circuit> getMaxHours(final List<Circuit> circuitsList) {
    final Map<String, Circuit> mappedCircuitsById = new HashMap<String, Circuit>();

    for (final Circuit circuit : circuitsList) {
        if (!mappedCircuitsById.containsKey(circuit.getCircuitID())) {
            mappedCircuitsById.put(circuit.getCircuitID(), circuit);
        } else {
            final Circuit existingMax = mappedCircuitsById.get(circuit.getCircuitID());
            if (circuit.getHours() > existingMax.getHours()) mappedCircuitsById.put(circuit.getCircuitID(), circuit);
            else if (circuit.getHours() == existingMax.getHours()) {
                if (circuit.getDepartment().equals("Electricity")) mappedCircuitsById.put(circuit.getCircuitID(), circuit);
                else if (existingMax.getDepartment().equals("Electricity")) mappedCircuitsById.put(circuit.getCircuitID(), existingMax);
            }
        }
    }

    return mappedCircuitsById;
}