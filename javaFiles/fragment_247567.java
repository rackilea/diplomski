while (line != null) {
    for (int i = 0; i < faults.length; i++) {
        if (line.contains(faults[i])) {
            count++;
            output.write(line + "Total: " + count + "\n");
            System.out.println(line);
            break;
        }
    }
    // System.out.println("File Written");
    line = reader.readLine();
}