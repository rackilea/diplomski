// ... add some elements
Iterator<String> stringIter = stringList.iterator();
int i = 0;
while (stringIter.hasNext()) {
    String command = stringIter.next();
    if (command.contains("%")) {
        command = command.replace("%", backupStorePath);
        stringList.set(i, command);
    }
    i++;
}