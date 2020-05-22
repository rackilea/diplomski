package tiesImpl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Prefix table based on Trie structure. Allows to perform incremental lookup
 * and match based on search key prefixes (classic example - determine phone
 * area code for given phone number)
 *
 * @param <V> a type of value object to be stored along with prefix (e.g when
 * key is a country name, the value could be a name of the country)
 *
 * @author Vladimir Kroz
 * https://vkroz.wordpress.com/2012/03/23/prefix-table-trie-implementation-in-java/
 */
public class Trie<V> {

Entry<V> entry;
char key;
Map<Character, Trie<V>> children;

public Trie() {
    this.children = new HashMap<>(10);
    entry = new Entry<>();
}

/**
 * non-public, used by _put()
 */
Trie(char key) {
    this.children = new HashMap<>(10);
    this.key = key;
    entry = new Entry<>();
}

public void put(String key, V value) {
    _put(new StringBuffer(key), new StringBuffer(""), value);
}

void _put(StringBuffer remainder, StringBuffer prefix, V value) {
    if (remainder.length() > 0) {
        char keyElement = remainder.charAt(0);
        Trie<V> t = null;
        try {
            t = children.get(keyElement);
        } catch (IndexOutOfBoundsException e) {
        }
        if (t == null) {
            t = new Trie<>(keyElement);
            children.put(keyElement, t);
        }
        prefix.append(remainder.charAt(0));
        t._put(remainder.deleteCharAt(0), prefix, value);
    } else {
        this.entry.value = value;
        this.entry.prefix = prefix.toString();
    }

}

/**
 * Retrieves element from prefix table matching as a prefix to provided
 * key. E.g. if key is "37251656565" and prefix table has node "372" then
 * this call will return the value of "372"
 *
 * @param key a string which starts with prefix to be searched in the table
 * (e.g. phone number)
 * @return an Object associated with matching prefix (i.e if key is a phone
 * number it may return a corresponding country name)
 */
public V get(String key) {
    return _get(new StringBuffer(key), 0);
}

/**
 * Returns true if key has matching prefix in the table
 *
 * @param key
 * @return
 */
public boolean hasPrefix(String key) {
    return this.get(key) != null;
}

V _get(StringBuffer key, int level) {
    if (key.length() > 0) {
        Trie<V> t = children.get(key.charAt(0));
        if (t != null) {
            //FYI: modified code to return deepest with value instead of returning null if prefix doesn't have corresponding value.
            V result = t._get(key.deleteCharAt(0), ++level);
            return result == null ? entry.value : result;

        } else {
            return (level > 0) ? entry.value : null;
        }

    } else {
        return entry.value;
    }
}

@Override
//For debugging
public String toString() {

    Iterator<Character> it = children.keySet().iterator();
    StringBuffer childs = new StringBuffer();

    while (it.hasNext()) {
        Character _key = it.next();
        childs.append(String.format("\n%s\n",
                //Adding a tab to the beginning of every line to create a visual tree
                String.format("%s: %s", _key, children.get(_key)).replaceAll("(?m)(^)", "\t")));
    }

    return String.format("Trie [entry=%s, children=%s]", entry, childs);
}

static public class Entry<V> {

    String prefix;
    V value;

    public Entry() {
    }

    public Entry(String p, V v) {
        prefix = p;
        value = v;
    }

    public String prefix() {
        return prefix;
    }

    public V value() {
        return value;
    }

    @Override
    public String toString() {
        return "Entry [prefix=" + prefix + ", value=" + value + "]";
    }

}
}