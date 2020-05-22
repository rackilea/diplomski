Books book = (Books) session.get(Books.class, book_id);
User user =  (User) session.get(User.class, user_id);
List<User> users=book.getUser();
users.add(user);
book.setUser(users);
session.saveOrUpdate(book);