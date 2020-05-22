private class MyAdapter<G, C> extends BaseExpandableListAdapter {
    private List<G> groups;
    private Map<G, List<C>> childMap;
    private Map<G, List<C>> selectedItems;

    public MyAdapter(List<G> groups, Map<G, List<C>> childMap){
        this.groups = groups;
        this.childMap = childMap;
        this.selectedItems = new HashMap<>();
    }

    public boolean isSelected(int groupPosition, int childPosition){
        G group = groups.get(groupPosition);
        // getChild is adapter Fn and is the same as
        // G group = groups.get(groupPosition)
        // C child = childMap.get(group).get(childPosition);
        C child = getChild(groupPosition, childPosition);
        List<C> sel = selectedItems.get(group);
        return sel != null && sel.contains(child);
    }

    public void toggleSelection(int groupPosition, int childPosition){
        G group = groups.get(groupPosition);
        C child = getChild(groupPosition,childPosition);
        List<C> sel = selectedItems.get(group);
        if (sel == null){
            sel = new ArrayList<>(); // Lasy arrays creation
            //can init all arrays in constructor and never check for nulls
            selectedItems.put(group, sel);
        }
        if (sel.contains(child)) sel.remove(child);
        else sel.add(child);
    }
    ... // Adapter fns can find in git repo