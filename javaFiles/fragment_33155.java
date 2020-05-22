// ...
.firstOrDefault(yourDefaultValue, new Func1<Entry, Boolean>() {
    @Override
    public Boolean call(Entry entry) {
        return entry.getId() == id;
    }
})
// ...