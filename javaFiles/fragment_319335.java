public class MapCompare {

    public static boolean listContains(List<String> annotationList, String value) {
        if(annotationList.contains(value)) {
            // 100% Match
            return true;
        }
        for(String s: annotationList) {
            if (s.contains(value) || value.contains(s)) {
                // Partial Match
                return true;
            }
        }
        return false;
    }

    public static List<Integer> compareLists(List<String> annotationList, List<String> rageList){
        List<Integer> compareResults = new ArrayList<Integer>();
        if(annotationList == null || rageList == null) return Arrays.asList(0, 0, 0);
        Integer truePositiveCount = 0;
        Integer falseNegativeCount = 0;
        Integer falsePositiveCount = 0;

        for(String r: rageList) {
            if(listContains(annotationList, r)) {
                System.out.println("\tTrue Positive: " + r);
                truePositiveCount ++;
            } else {
                System.out.println("\tFalse Positive: " + r);
                falsePositiveCount ++;
            }
        }

        for(String s: annotationList) {
            if(listContains(rageList, s) == false){
                System.out.println("\tFalse Negative: " + s);
                falseNegativeCount ++;
            }
        }

        compareResults.add(truePositiveCount);
        compareResults.add(falseNegativeCount);
        compareResults.add(falsePositiveCount);

        System.out.println();

        return compareResults;
    }

    private static List<Integer> compareMaps(LinkedHashMap<String, List<String>> annotationMap, LinkedHashMap<String, List<String>> rageMap) {
        List<Integer> compareResults = new ArrayList<Integer>();
        System.out.println("Organization:");
        compareResults.addAll(compareLists(annotationMap.get("ORGANIZATION"), rageMap.get("ORGANIZATION")));
        System.out.println("Person:");
        compareResults.addAll(compareLists(annotationMap.get("PERSON"), rageMap.get("PERSON")));
        System.out.println("Location:");
        compareResults.addAll(compareLists(annotationMap.get("LOCATION"), rageMap.get("LOCATION")));
        System.out.println(compareResults);
        return compareResults;
    }

    public static void main(String[] args) {
        LinkedHashMap<String, List<String>> Map1 = new LinkedHashMap<>();
        List<String> m1l1 = Arrays.asList("Fulton Tax Commissioner's Office", "Grady Hospital", "Fulton Health Department");
        List<String> m1l2 = Arrays.asList("Bellwood", "Alpharetta");
        List<String> m1l3 = Arrays.asList();
        Map1.put("ORGANIZATION", m1l1);
        Map1.put("LOCATION", m1l2);
        Map1.put("PERSON", m1l3);

        LinkedHashMap<String, List<String>> Map2 = new LinkedHashMap<>();
        List<String> m2l1 = Arrays.asList("Atlanta Police Department", "Fulton Tax Commissioner", "Fulton Health Department");
        List<String> m2l2 = Arrays.asList("Alpharetta");
        List<String> m2l3 = Arrays.asList("Bellwood", "Grady Hospital");

        Map2.put("ORGANIZATION", m2l1);
        Map2.put("LOCATION", m2l2);
        Map2.put("PERSON", m2l3);

        compareMaps(Map1, Map2);

    }

}