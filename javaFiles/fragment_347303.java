function sysCall_actuation()
    local name = sim.getObjectName(sim.getObjectAssociatedWithScript(sim.handle_self))
    result,distance,detectedPoint,detectedObjectHandle = sim.handleProximitySensor(sim.handle_self)
    if distance then
        sim.setFloatSignal("mydistance", distance);
    end
end