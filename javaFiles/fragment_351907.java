String[] fields = thisLine.split(",");

double[] values = new String[fields.length - 1];

for (int i = 1; i < fields.length; i++) {
    values[i - 1] = Double.parseDouble[fields[i]);
}

lines.add(values);