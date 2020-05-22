@Override
    public T next() {
        if(this.hasNext()) {
            @SuppressWarnings("unchecked")
            T value = (T)names[index++];
            return value;
        }
        return null;
    }