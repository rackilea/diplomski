Map<String, List<RateDTO>> map;

public void writeToParcel(Parcel out, int flags) {
    out.writeInt(map.size());

    for (Map.Entry<String, List<RateDTO>> entry : map.entrySet()) {
        out.writeString(entry.getKey());

        final List<RateDTO> list = entry.getValue();
        final int listLength = list.size();

        out.writeInt(listLength);

        for (RateDTO item: list) {
            out.writeParcelable(item, 0);
        }
    }
}

private MyParcelable(Parcel in) {
    final int size = in.readInt();

    for (int i = 0; i < size; i++) {
        final String key = in.readString();
        final int listLength = in.readInt();

        final List<RateDTO> list = new ArrayList<RateDTO>(listLength);
        for (int j = 0; j < listLength; j++) {
            final RateDTO value = in.readParcelable(ParentClass.class.getClassLoader());
            list.add(value);
        }

        map.put(key, list);
    }
}