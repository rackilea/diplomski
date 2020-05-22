String line;
while ((line = br.readLine()) != null) {
    /* We always write out the line (without an end-of-line character(s)) */
    bw.write(line);

    /* If the line does not end with a space, write out an end-of-line character */
    if (!line.endsWith(" ")) {
        bw.newLine();
    }
}