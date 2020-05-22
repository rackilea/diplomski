Scanner s = new Scanner(System.in);

  Product p = new Product();
  p.setPid(s.nextInt());
  p.setName(s.next().concat(s.nextLine()));
  p.setPrice(s.nextDouble());