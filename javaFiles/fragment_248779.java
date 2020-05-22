for (int i = 0; i < 10; i++) {
    Modelclass obj = new Modelclass(); //This is the key to solve it.
    obj.setName(2 + i);
    obj.setRoolno(4 + i);
    System.out.println(obj);

    al.add(obj);
    System.out.println(obj.getName() + "" + obj.getRoolno());
}