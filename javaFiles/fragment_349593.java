String str = "[";
boolean first = true;
for (double d : data)  {
    if (!first) {
        str += ", ";
    }
    str += d;
    first = false;
}
str += "]";