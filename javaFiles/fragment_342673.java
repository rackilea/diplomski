<%

String a = request.getParameter("take");if(a!=null)
    {

        try {
            Robot robot = new Robot();
            BufferedImage screenShot = robot
                    .createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            String home = System.getProperty("user.home");

            ImageIO.write(screenShot, "JPG", new File(home + "\\Desktop\\test.jpg"));

        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

}%>

<form action="#"method="post">

<input type="hidden"name="take"id="take"value="take_photo"/><input type="submit"/>
    </form>