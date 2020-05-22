public class RecordHolder {

    Map<Integer,String> namesById = new HashMap<>();
    Map<Integer,List<Integer>> childrenById = new HashMap<>();

    public void addRow(Integer id, String name, Integer parent) {
        namesById.put(id, name);
        List<Integer> children = childrenById.get(parent);
        if (children == null) {
            children = new ArrayList<>();
            childrenById.put(parent, children);
        }
        children.add(id);
    }

    public Map<String,List<String>> processRecordHolder() {
        Map<String,List<String>> results = new HashMap<>();
        descendants(null, results);
        return results;
    }

    private List<String> descendants(Integer id, Map<String, List<String>> results) {
        final List<String> childrenNames = new ArrayList<>();

        final List<Integer> childrenIds = childrenById.get(id);
        if (childrenIds != null && childrenIds.size() > 0) {
            for (Integer childrenId : childrenIds) {

                final String childName = namesById.get(childrenId);
                childrenNames.add(childName);

                final List<String> grandchildrenNames = descendants(childrenId, results);
                childrenNames.addAll(grandchildrenNames);
            }

            if (id != null) {
                results.put(namesById.get(id), childrenNames);
            }
        }

        return childrenNames;
    }
}