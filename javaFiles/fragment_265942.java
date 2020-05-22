Map<String, String> slices = new HashMap<String, String>();
slices.put("Title 1", "100");
slices.put("Title 2", "200");

Pie pie = new Pie(slices);
JAXB.marshal(pie, System.out);