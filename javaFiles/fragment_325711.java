String[][] input = { { "Nirvana Narayan Narayan", "Nirvana Nirvana--Narayan" },
                     { "Kim Do  Do", "Kim  Kim--Do" },
                     { "Kiri Wood   Wood", "Kiri   Kiri--Wood" },
                     { "Quinn Hume  Hume", "Quinn  Quinn--Hume" } };

// Find column widths
int[] widths = new int[input[0].length];
for (String[] row : input)
    for (int i = 0; i < widths.length; i++)
        widths[i] = Math.max(widths[i], row[i].length());

// Build format string
StringBuilder buf = new StringBuilder();
for (int i = 0; i < widths.length - 1; i++)
    buf.append("%-").append(widths[i]).append("s ");
String fmt = buf.append("%s%n").toString();

// Print table
for (String[] row : input)
    System.out.printf(fmt, (Object[]) row);