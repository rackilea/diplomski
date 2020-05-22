if (timesthatisrepeated > maximumtimesthatisrepeated) {
//  mode = DAT[i];  deprecaded line
    mode.clear();
    mode.add(DAT[i]);
    maximumtimesthatisrepeated = timesthatisrepeated;
} else if (timesthatisrepeated == maximumtimesthatisrepeated) { // checks for additional modes
    if (!mode.contains(DAT[i])) {    // recognices duplicates
        mode.add(DAT[i]);
    }
}