...
    Parcelable.Creator<T> creator;
    synchronized (mCreators) {
        HashMap<String,Parcelable.Creator> map = mCreators.get(loader);
        if (map == null) {
            map = new HashMap<String,Parcelable.Creator>();
            mCreators.put(loader, map);
        }
        creator = map.get(name);
        if (creator == null) {
            try {
                Class c = loader == null ?
                    Class.forName(name) : Class.forName(name, true, loader);
                Field f = c.getField("CREATOR");
                creator = (Parcelable.Creator)f.get(null);
            }
...