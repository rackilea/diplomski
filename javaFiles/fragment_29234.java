public Pair<Integer,Image> image2()throws SQLException
{
    int id;
    System.out.println("I am in Image");

    try {

        System.out.println(rs);

        boolean anyResults = false;

        boolean hasNext = rs.next();


        if (hasNext )
        {

            anyResults = true;

            Blob blob = rs.getBlob("image");

            id = rs.getInt("id");

            System.out.println(id);
            System.out.println(blob);
            System.out.println(blob.length());


            InputStream in = blob.getBinaryStream(1, blob.length());

            System.out.println(hasNext );
            System.out.println(in);

            BufferedImage image = ImageIO.read(in);
            System.out.println(image);

            Image image1 = SwingFXUtils.toFXImage(image,null);


            return new Pair<>(id, image1);

        }
        else if (!anyResults)
        {
            JOptionPane.showMessageDialog(null, "Not Found");
        }


        System.out.println("reached here");


    } catch (Exception e)
    {
        e.printStackTrace();
    }

    return null;
}