StringBuilder line = new StringBuilder(1024);
FileInputStream in = new FileInputStream(file);

int next;

boolean lb = true;

while ((next = in.read()) != -1) {

    if (next == 0xD || next == 0xA) {

        // skip if there are multiple line breaks
        if (lb) continue;

        lb = true;
        sendNextLineSomewhere(line.toString());

        // avoid new object creations
        line.delete(0, line.length());

    } else {

        lb = false;
        line.append((char)next);
    }
}

in.close();