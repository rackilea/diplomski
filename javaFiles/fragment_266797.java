byte[] valueAsBytes = ...;
int valueAsInt = ((valueAsBytes[0] & 0xff) << 24) |
                 ((valueAsBytes[1] & 0xff) << 16) |
                 ((valueAsBytes[2] & 0xff) << 8) |
                 (valueAsBytes[3] & 0xff);
String valueAsString = String.valueof(valueAsInt);