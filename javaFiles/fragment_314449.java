private void DownloadResource(String directory) {
    try {

        Resources rst = book.getResources();
        Collection<Resource> clrst = rst.getAll();
        Iterator<Resource> itr = clrst.iterator();

        while (itr.hasNext()) {
            Resource rs = itr.next();

            if ((rs.getMediaType() == MediatypeService.JPG)
                    || (rs.getMediaType() == MediatypeService.PNG)
                    || (rs.getMediaType() == MediatypeService.GIF)) {

                Log.d("Href", rs.getHref());

                File oppath1 = new File(directory, rs.getHref().replace("OEBPS/", ""));

                oppath1.getParentFile().mkdirs();
                oppath1.createNewFile();

                System.out.println("Path : "+oppath1.getParentFile().getAbsolutePath());


                FileOutputStream fos1 = new FileOutputStream(oppath1);
                fos1.write(rs.getData());
                fos1.close();

            } else if (rs.getMediaType() == MediatypeService.CSS) {

                File oppath = new File(directory, rs.getHref());

                oppath.getParentFile().mkdirs();
                oppath.createNewFile();

                FileOutputStream fos = new FileOutputStream(oppath);
                fos.write(rs.getData());
                fos.close();

            }

        }

    } catch (Exception e) {

    }
}