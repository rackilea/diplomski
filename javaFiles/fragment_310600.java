List<Component> components = new ArrayList<Components>
components .addAll(Arrays.asList(ToolbarPool.getDefault().findToolbar("AddEditDelete").getComponents()));
components .addAll(Arrays.asList(ToolbarPool.getDefault().findToolbar("Navigation").getComponents()));
for (Component component : components) {
    component.setEnabled(false);
}