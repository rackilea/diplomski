/**
 * Determine if two JSONObjects are similar.
 * They must contain the same set of names which must be associated with
 * similar values.
 *
 * @param other The other JSONObject
 * @return true if they are equal
 */
public boolean similar(Object other) {
    try {
        if (!(other instanceof JSONObject)) {
            return false;
        }
        Set<String> set = this.keySet();
        if (!set.equals(((JSONObject)other).keySet())) {
            return false;
        }
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            Object valueThis = this.get(name);
            Object valueOther = ((JSONObject)other).get(name);
            if (valueThis instanceof JSONObject) {
                if (!((JSONObject)valueThis).similar(valueOther)) {
                    return false;
                }
            } else if (valueThis instanceof JSONArray) {
                if (!((JSONArray)valueThis).similar(valueOther)) {
                    return false;
                }
            } else if (!valueThis.equals(valueOther)) {
                return false;
            }
        }
        return true;
    } catch (Throwable exception) {
        return false;
    }
}