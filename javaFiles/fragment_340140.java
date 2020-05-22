select xxx as time, yyy as len from zzz where ...

List<Object[]> list = query.list(); 

for (Object[] row : list) {
   Date date = (Date) row[0];
   int len = ((Number) row[1]).intValue();
   String str = " " + date.getTime()  + ", " + len;
}