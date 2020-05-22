protected void doSomething(JButton src) {
        if (src.equals(RA1)) path1 = openDataBrowser().getAbsolutePath().replace("\\", "/");
        else if (src.equals(RA2)) path2 = openDataBrowser().getAbsolutePath().replace("\\", "/");
        else if (src.equals(RA3)) path3 = openDataBrowser().getAbsolutePath().replace("\\", "/");
        else if (src.equals(finish)) {
             System.out.println(path1);
             System.out.println(path2);
             System.out.println(path3);
      }
}