String path=FacesContext.getCurrentInstance().getExternalContext().getResource("/samp.png").getPath();
File directory = new File(path).getAbsoluteFile();
    System.out.println("***directory*" + directory.getAbsolutePath());

    if (directory.exists()) {
        System.setProperty("user.dir", directory.getAbsolutePath());
    }