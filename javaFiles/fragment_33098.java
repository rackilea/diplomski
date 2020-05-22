Serializable s = this.getIntent().getSerializableExtra("results");
Object[] o = (Object[]) s;
if (o != null) {
    resultSet = new TreeSet<RatedMessage>(new Comp());
    for (int i = 0; i < o.length; i++) {
        if (o[i] instanceof RatedMessage) {
            resultSet.add((RatedMessage) o[i]);
        }
    }
}