@SuppressWarnings({"rawtypes", "unchecked"})
public static void main(String[] args) {
  final String in = "5 9 + 2 * 6 5 * +";
  final Deque<Object> s = new LinkedList();
  for (String t : in.split(" ")) {
    if (t.equals("+")) s.push((Integer)s.pop() + (Integer)s.pop());
    else if (t.equals("*")) s.push((Integer)s.pop() * (Integer)s.pop());
    else s.push(Integer.parseInt(t));
  }
  System.out.println(s.pop());
}