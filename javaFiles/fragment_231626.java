List<String> bean = new ArrayList<>();
bean.add("1");
bean.add("2");
bean.add("3");
bean.add("4");
bean.add("5");
List<String> dto = new ArrayList<>();
dto.add("1");
dto.add("2");

List<String> toRemove = new ArrayList<>();

bean.forEach(obj -> {
    if (!dto.contains(obj)) {
        toRemove.add(obj);
    }
});

bean.removeAll(toRemove);

System.out.println(bean);