private final SharedPreferences _settings;
/**
 * Serialize all preferences into an output stream
 * @param os OutputStream to write to
 * @return True iff successful
 */
public boolean serialize(final @NonNull OutputStream os) {
    ObjectOutputStream oos = null;
    try {
        oos = new ObjectOutputStream(os);
        oos.writeObject(_settings.getAll());
        oos.close();
    } catch (IOException e) {
        Log.e(TAG, "Error serializing preferences", BuildConfig.DEBUG ? e : null);
        return false;
    } finally {
        Utils.closeQuietly(oos, os);
    }
    return true;
}

/**
 * Read all preferences from an input stream.
 * Schedules a full preference clean, then deserializes the options present in the given stream.
 * If the given object contains an unknown class, the deserialization is aborted and the underlying
 * preferences are not changed by this method
 * @param is Input stream to load the preferences from
 * @return True iff the new values were successfully written to persistent storage
 *
 * @throws IllegalArgumentException
 */
public boolean deserialize(final @NonNull InputStream is) {
    ObjectInputStream ois = null;
    Map<String, Object> map = null;
    try {
        ois = new ObjectInputStream(is);
        map = (Map) ois.readObject();
    } catch (IOException | ClassNotFoundException e) {
        Log.e(TAG, "Error deserializing preferences", BuildConfig.DEBUG ? e : null);
        return false;
    } finally {
        Utils.closeQuietly(ois, is);
    }

    SharedPreferences.Editor editor = _settings.edit();
    editor.clear();

    for (Map.Entry<String, Object> e : map.entrySet()) {
        // Unfortunately, the editor only provides typed setters
        if (e.getValue() instanceof Boolean) {
            editor.putBoolean(e.getKey(), (Boolean)e.getValue());
        } else if (e.getValue() instanceof String) {
            editor.putString(e.getKey(), (String)e.getValue());
        } else if (e.getValue() instanceof Integer) {
            editor.putInt(e.getKey(), (int)e.getValue());
        } else if (e.getValue() instanceof Float) {
            editor.putFloat(e.getKey(), (float)e.getValue());
        } else if (e.getValue() instanceof Long) {
            editor.putLong(e.getKey(), (Long) e.getValue());
        } else if (e.getValue() instanceof Set) {
            editor.putStringSet(e.getKey(), (Set<String>) e.getValue());
        } else {
            throw new IllegalArgumentException("Type " + e.getValue().getClass().getName() + " is unknown");
        }
    }
    return editor.commit();
}