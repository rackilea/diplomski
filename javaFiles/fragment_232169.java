final Set<String> keys = allowedInput.keySet();
final int keyNumber = (int)(Math.random() * keys.size());
final Iterator<String> keyIterator = keys.iterator();

String randomKey = null;

for (int i = 0; i < keyNumber && keyIterator.hasNext(); i++) {
    randomKey = keyIterator.next();
}

if (randomKey == null) {
    // This should not happen unless the map was empty, or it was modified
    // externally.  Handle the potential error case accordingly.
}

final HashSet<Integer> value = allowedInput.get(randomKey);

// `value` now contains a random element from the `allowedInput` map.