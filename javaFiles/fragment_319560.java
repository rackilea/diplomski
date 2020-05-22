@Override
public int compare(ArrayList<Order> arg0, ArrayList<Order> arg1) {
  if (arg0.isEmpty()) {
    return -1;
  }
  if (arg1.isEmpty()) {
    return 1;
  }

  return Integer.compare(arg0.get(0).getPrice(), arg1.get(0).getPrice());
}