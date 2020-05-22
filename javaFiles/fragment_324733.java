if (line.trim().startsWith("Scenario")) {
    count++;
    writer.write("@tag"+count);
    writer.write ("\n"); 
}
writer.write (line);
writer.write ("\n");