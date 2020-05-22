class Points {

        String name;
        String address;
        int phone;
        int coord1;
        int coord2;

        // getters+setters
    };

    class PointsIdentifier {

        private String name;
        private String address;

        public PointsIdentifier(String name, String address) {
            this.name = name;
            this.address = address;

        }

        public boolean contains(String seq) {
            return name.contains(seq) || address.contains(seq);
        }

        @Override
        public boolean equals(Object obj) {
            Points other = (Points) obj;
            return name.equals(other.name) && address.equals(other.address);
        }

        @Override
        public int hashCode() {
            return name.hashCode() + address.hashCode();
        }
    };

    class PointsCollection {
        private Map<PointsIdentifier, Points> map;

        public PointsCollection() {
            map = new HashMap<PointsIdentifier, Points>();
        }

        public void add(Points p) {
            map.put(new PointsIdentifier(p.name, p.address), p);
        }

        public List<Points> findIdsContaining(String seq) {
            List<Points> resultList = new ArrayList<Points>();
            for (Entry<PointsIdentifier, Points> entry : map.entrySet()) {
                if (entry.getKey().contains(seq)) {
                    resultList.add(entry.getValue());
                }
            }
            // optionally cache result
            return resultList;
        }
    }

    public class Question_11881630 {

        public static void main(String[] args) {
            PointsCollection places = createCollection(10000);
            System.out.println("Collection created");
        String seq = "1";

        System.out.format("Searching for: \"%s\"\n", seq);
        List<Points> verifySearch = verifySearch(places, seq);
        //show(verifySearch);
    }

    private static void show(List<Points> verifySearch) {
        int i = 1;
        for (Points p : verifySearch) {
            System.out.println(i + ": " + p.name + ", " + p.address);
            i++;
        }
    }

    private static List<Points> verifySearch(PointsCollection places, String seq) {
        long start = System.currentTimeMillis();
        List<Points> searchResult = places.findIdsContaining(seq);
        System.out.println("Search results: " + searchResult.size());
        long end = System.currentTimeMillis();
        System.out.println("Operation time: " + formatTime(end - start));
        return searchResult;
    }

    private static String formatTime(long elapsed) {
        return elapsed + " miliseconds";
    }

    private static PointsCollection createCollection(int number) {
        PointsCollection coll = new PointsCollection();
        while (number > 0) {
            coll.add(createSamplePoint(number));
            number--;
        }
        return coll;
    }

    private static Points createSamplePoint(int number) {
        Points p = new Points();
        p.name = "VeryVeryLongName: " + number;
        p.address = "VeryVeryLongLongAddress: " + number;
            p.coord1 = 123;
            p.coord2 = 456;
            return p;
        }
    }