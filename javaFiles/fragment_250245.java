public List<ItemDTO> process(Long id, Integer level) {
    List<ItemDTO> list = new ArrayList<>();

    // check the recursive logic's terminating condition
    if (level == 5) {
        // reached the intended bottom, return
        return list;
    }

    List<Item> children = itemDAO.findChildrenForItem(id);
    if (children != null && children.size() > 0) {
        for (Item child : children) {
            level = level != null ? level : 0;
            ItemDTO dto = new ItemDTO();
            dto.setId(String.valueOf(child.getId()));
            dto.setText(child.getLib());

            // you don't need a lot of logic here, just increment the level in the recursive call
            dto.setChildren(process(child.getId(), level + 1));

            list.add(dto);
        }
    }

    return list;
}