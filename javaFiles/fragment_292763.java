// Loop through all messages and change the extras' key names to lowercase (only for keys of interest)
Bundle tempBundle = new Bundle();
ArrayList<String> keysToBeRemoved = new ArrayList<>();
Bundle extras = messages.get(i).getExtras();

for (String key : extras.keySet()) {
    // Check if key is not all lower case and if it is a key of interest
    if (!key.equals(key.toLowerCase()) && isKeyOfInterest(key)) {
        // Save value to bundle using lowercase key value
        tempBundle.putString(key.toLowerCase(), extras.getString(key));
        // Add original version of this key to a list for later deletion
        keysToBeRemoved.add(key);
    }
}

// Remove original entries from message extras
for (String originalKey : keysToBeRemoved) {
    extras.remove(originalKey);
}

// Add all new bundle entries to message extras
extras.putAll(tempBundle);