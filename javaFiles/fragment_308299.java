public class Test4 {
    public static void main(String[] args) {
        List<Pojo> pojoList = new ArrayList<>();
        pojoList.add(new Pojo("A", 20.00d));
        pojoList.add(new Pojo("A", 10.00d));
        pojoList.add(new Pojo("B", 23.00d));
        pojoList.add(new Pojo("A", 11.00d));
        pojoList.add(new Pojo("C", 38.00d));
        pojoList.add(new Pojo("B", 233.00d));
        Map<String, Optional<Pojo>> map = pojoList.stream()
                .collect(Collectors.groupingBy(Pojo::getType, Collectors.maxBy(Comparator.comparing(Pojo::getMoney))));
        List<Pojo> pojos = map.values().stream().map(Optional::get).collect(Collectors.toList());
        System.out.println(pojos);

    }

    static class Pojo {
        public String type;
        public double money;

        public Pojo(String type, double money) {
            this.type = type;
            this.money = money;
        }

        public double getMoney() {
            return money;
        }

        public String getType() {
            return type;
        }

        @Override
        public String toString() {
            return "Pojo [type=" + type + ", money=" + money + "]";
        }

    }
}