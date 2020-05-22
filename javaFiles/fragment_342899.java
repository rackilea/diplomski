import java.util.*;

// PUBLIC DOMAIN
public class SmallMap extends AbstractMap {

    private Entry entry = null;

    public void clear() { entry = null; }
    public boolean isEmpty() { return entry==null; }    
    public int size() {
        int r = 0;
        for(Entry e = entry; e!=null; e = e.next) r++;
        return r;
    }

    public boolean containsKey(Object key) {
        for(Entry e = entry; e!=null; e = e.next){
            if(e.key.equals(key)){
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Object value) {
        for(Entry e = entry; e!=null; e = e.next){
            if(e.value==null){
                if(value==null) return true;
            }else if(e.value.equals(value)){
                return true;
            }
        }
        return false;
    }

    public Object get(Object key) {
        for(Entry e = entry; e!=null; e = e.next){
            if(e.key.equals(key)){
                return e.value;
            }
        }
        return null;
    }

    public Object put(Object key, Object value) {
        for(Entry e = entry; e!=null; e = e.next){
            if(e.key.equals(key)){
                Object r = e.value;
                e.value = value;
                return r;
            }
        }
        entry = new Entry(key, value, entry);
        return null;
    }

    public Object remove(Object key) {
        if(entry!=null){
            if(entry.key.equals(key)){
                Object r = entry.value;
                entry = entry.next;
                return r;
            }
            for(Entry e = entry; e.next!=null; e = e.next){
                if(key.equals(e.next.key)){
                    Object r = e.next.value;
                    e.next = e.next.next;
                    return r;
                }
            }
        }
        return null;
    }

    public Set entrySet() { return new EntrySet(); }

    class EntrySet extends AbstractSet{
        public Iterator iterator() {
            return new Iterator(){

                Entry last = null;
                Entry e = entry;
                public boolean hasNext() { return e!=null; }

                public Object next() { 
                    last = e;
                    e = e.next;
                    return last;
                }

                public void remove() { 
                    if(last == null) throw new IllegalStateException();
                    SmallMap.this.remove(last.key);
                }
            };
        }

        public int size() { return SmallMap.this.size();}
    }

    static private class Entry implements java.util.Map.Entry {
        final Object key;
        Object value;
        Entry next; 
        Entry(Object key, Object value, Entry next){
            if(key==null) throw new NullPointerException();
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public Object getKey() { return key; }
        public Object getValue() { return value; }
        public Object setValue(Object value) { 
            Object r = this.value;
            this.value = value;
            return r;
        }
        public int hashCode() {
            return (key   == null ? 0 :   key.hashCode()) ^
               (value == null ? 0 : value.hashCode());
        }
    }
}