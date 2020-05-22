final Map<Integer, Board> boards = new HashMap<>();
items.items.forEach(item -> { if (item instanceof Board) boards.put(item.contentId, (Board)item); });
final Map<Integer, Role> roles = new HashMap<>();
items.items.forEach(item -> { if (item instanceof Role) roles.put(item.contentId, (Role)item); });
final List<Person> persons = new ArrayList<>();
items.items.forEach(item -> { if (item instanceof Person) persons.add((Person)item); });

roles.values().forEach(role -> role.board = boards.get(role.boardId));
persons.forEach(person -> person.role = roles.get(person.hasRole));