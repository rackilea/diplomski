if (av.length == 0) {
  cp.add(new FileTree(new File(".")));
} else {
  cp.setLayout(new BoxLayout(cp, BoxLayout.X_AXIS));
  for (int i = 0; i < av.length; i++)
    cp.add(new FileTree(new File(av[i])));
}