...
boolean pastCheckpoint = false;
int keyIndex = 0;
// We will store keys in here
List<String> keys = new ArrayList<String>();

while(it.hasNext()){
    line = it.nextLine();

    if (line.contains(check)) {
        // We don't actually want to store this line,
        // so just set the flag 
        pastCheckpoint = true;
    }
    else if (pastCheckpoint) {
        // We must already have a key defined
        // Get that key and increment the counter for next time
        hashMap.put(keys.get(keyIndex++), line);
    }
    else {
        // We're not past the checkpoint so save this key for later
        keys.add(line);
    }
}
...