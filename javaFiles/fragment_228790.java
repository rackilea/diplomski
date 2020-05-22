Map<String, Object> map = new HashMap<>();
// Set to store the modified keys,
// Also store the trimmed String for performance reasons 
Set<String[]> modifiedSet = new HashSet<>();
for (Entry<String, Object> entry : map.entrySet()) {
    String trimmed = entry.getKey().trim();
    if (!trimmed.equals(entry.getKey()))
        modifiedSet.add(new String[]{entry.getKey(), trimmed});
}

// Changing a key can be done in one step:
// Removing the old entry (which returns the old value) and put the new   
for (String[] modified : modifiedSet)
    map.put(modified[1], map.remove(modified[0]));