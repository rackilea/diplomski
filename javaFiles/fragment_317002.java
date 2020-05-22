String[] t = new String[2*timeSlots.length];

for (int i = 0; i < timeSlots.length; i++) {
    String[] temp = timeSlots[i].split("\\-");
    t[2*i] = temp[0].trim();
    t[2*i+1] = temp[1].trim();
}