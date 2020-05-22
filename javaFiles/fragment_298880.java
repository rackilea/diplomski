StringBuffer string = new StringBuffer();
boolean first = true;
for (String keyinside: values.keySet()) {
    if (!first)
        string.append (", ");
    else
        first = false;
    string.append(keyinside + " " + values.get(keyinside));
}