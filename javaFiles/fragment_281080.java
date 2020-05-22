int i = 0;
while ((sCurrentLine = textReader.readLine()) != null) {
    array = sCurrentLine.split(",");
    id[i] = array[0];
    name[i] = array[1];
    asg1[i] = array[2];
    asg2[i] = array[3];
    i++;
}