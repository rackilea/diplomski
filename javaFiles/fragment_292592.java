class BTree<V extends Model> implements Serializable {  
/**
 * 
 */
private static final long serialVersionUID = -7602392759811243945L;

private static final int MINIMUM_CAPACITY = 15;

private Model[] values;
private int depth = 3;

public void insert(V newValue) {    
    int index = 0;
    while(true) {           
        ensureSpotExists(index);

        Model value = values[index];
        if (value == null) {                
            values[index] = newValue;
            return;
        } else if (newValue.getKey().hashCode() < value.getKey().hashCode()) {
            index = (2 * index) + 1;
        } else if (newValue.getKey().hashCode() > value.getKey().hashCode()) {
            index = (2 * index) + 2;
        } else {
            values[index] = newValue;
            return;
        }
    }
}

protected void ensureSpotExists(int index) {
    if (this.values == null) {
        this.values = new Model[MINIMUM_CAPACITY];
    } else if (this.values.length < index + 1) {
        Model[] temp = this.values;
        this.values = new Model[getSize(++depth)];
        for(int i = 0; i < temp.length; i++) {
            this.values[i] = temp[i];
        }
    }
}

protected static int getSize(int depth) {
    int size = 0;
    for(int i = 0; i <= depth; i++) {
        size += Math.pow(2, i);
    }

    return size;
}

public boolean containsKey(Object key) {
    return this.find(key) != null;
}

public V find(Object key) {
    return null;
}

void replace(Object key, V value) {
    return;
}

public List<Model> getAllValues() {
    return Arrays.asList(this.values);
}  
}