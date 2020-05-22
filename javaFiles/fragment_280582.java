/**
 * Create a new packet capture instance.
 */
public PacketCapture() {
    if (nextInstance >= INSTANCE_MAX) {
        throw new Error("Too many instances, exceeds " + INSTANCE_MAX);
    }

    instanceNum = nextInstance++;
}