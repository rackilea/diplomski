package org.jocl;

import java.nio.LongBuffer;

public class cl_device_partition_property_gateway {
    public static void set(cl_device_partition_property properties, long[] newArray) {
        properties.setBuffer(LongBuffer.wrap(newArray));
    }
}