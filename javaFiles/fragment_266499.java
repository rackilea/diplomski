@Override
public void sawOpcode(int seen) {
    if(seen == INVOKEINTERFACE) {
        if(getNameConstantOperand().equals("getParameter") && 
                getSigConstantOperand().equals("(Ljava/lang/String;)Ljava/lang/String;")
                /* && check the class if necessary */) {
            Object topValue = getStack().getStackItem(0).getConstant();
            if(topValue instanceof String) { // known parameter name like "name"
                // Iterate over locations corresponding to current PC 
                // (usually only one such location exists)
                for(Location location : vna.getCFG()
                        .getLocationsContainingInstructionWithOffset(getPC())) {
                    try {
                        // This frame contains value numbers 
                        // right after the INVOKEINTERFACE execution
                        ValueNumberFrame frame = vna.getFactAfterLocation(location);
                        // ValueNumber corresponding to the top stack value: 
                        // the return value of getParameters() method 
                        ValueNumber vn = frame.getTopValue();
                        vnToParameterName.put(vn, (String) topValue);
                    } catch (DataflowAnalysisException e) {
                        return;
                    }
                }
            }
        }
    }
}