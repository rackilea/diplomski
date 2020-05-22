// Assuming image is always TYPE_USHORT_GRAY
short[] values = ((DataBufferUShort) image.getRaster().getDataBuffer()).getData();

int min = Integer.MAX_VALUE;
int max = Integer.MIN_VALUE;
double mean;

for (int i = 0; i < values.length; i++) {
    int unsignedValue = values[i] & 0xFFFF;

    if (unsignedValue < min) {
        min = unsignedValue;
    }
    if (unsignedValue > max) {
        max = unsignedValue;
    }
    // ...etc. for mean and other values you like to extract. :-)
}