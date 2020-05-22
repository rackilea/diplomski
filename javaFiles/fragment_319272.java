while (rs2.next()) {
    int cid = rs2.getInt("category_id");
    String t1 = rs2.getString("T1");

    if (!categoryItemsList.containsKey(t1)) {
        categoryItemsList.put(t1, new LinkedList<Integer>());
    }

     categoryItemsList.get(t1).add(cid);
}