String[] fields = thisLine.split(",");

double[] values = new String[fields.length - 1];

Instant dateTime = Instant.parse(fields[1]);
values[0] = dateTime.toEpochMilli();

for (int i = 2; i < fields.length; i++) {
    values[i - 1] = Double.parseDouble[fields[i]);
}

lines.add(values);