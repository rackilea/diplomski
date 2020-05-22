// EntityFactory
public static Entity createById(ResultSet resultSet) {
    EntityData data = new EntityData(25);
    for (int sample = 1; sample <= 25; sample++) {
        String sample_R = new StringBuilder("sample_").append(sample).append("_R").toString();
        String sample_G = new StringBuilder("sample_").append(sample).append("_G").toString();
        String sample_B = new StringBuilder("sample_").append(sample).append("_B").toString();
        int r = resultSet.getInt(sample_R);
        int g = resultSet.getInt(sample_G);
        int b = resultSet.getInt(sample_B);

        data.add(r, g, b);
    }

    return new Entity(data);
}