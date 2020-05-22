if(seen == INVOKEINTERFACE && getMethodDescriptorOperand().getSlashedClassName()
        .equals("com/ibm/itim/ws/services/WSSessionService") &&
        getMethodDescriptorOperand().getName().equals("getNumber"))
    for(Location location : vna.getCFG()
            .getLocationsContainingInstructionWithOffset(getPC())) {
        try {
            // This frame contains value numbers 
            // right before the INVOKEINTERFACE execution
            ValueNumberFrame frame = vna.getFactAtLocation(location);
            // ValueNumber corresponding to the top stack value: 
            // the last parameter for getNumber method
            ValueNumber vn = frame.getStackValue(0);
            String parameterName = vnToParameterName.get(vn);
            if(parameterName != null) {
                // hurrah: this parameter is in fact 
                // the return value of getParameter(parameterName)
            }
        } catch (DataflowAnalysisException e) {
            return;
        }
    }