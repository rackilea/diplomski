int a = 0;
do 
{   
  System.out.println("hello# "+a);
  lm.book_ids.add(rs.getString(1));
  lm.branch_id.add(rs.getInt(2));
  lm.cards.add(rs.getString(3));
  lm.date_out.add(rs.getString(4));
  lm.due_date.add(rs.getString(5));
  a++;
} while (rs.next());