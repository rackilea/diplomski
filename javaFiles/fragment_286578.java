Map<Integer, Tile> map = new TreeMap<Integer, Tile>();
map.put(1, new Tile("name1", "description1", "imagepath1"));
map.put(2, new Tile("name2", "description2", "imagepath2"));
map.put(3, new Tile("name3", "description3", "imagepath3"));
// ...

request.setAttribute("map", map); // It'll be available as ${map} in JSP.
request.getRequestDispatcher("/WEB-INF/page.jsp").forward(request, response);