tree.addListener(SWT.MouseDown, (e) -> {
    System.out.println(new Point(e.x, e.y));
});
tree.addListener(SWT.MenuDetect, (e) -> {
    System.out.println(tree.toControl(e.x, e.y));
});