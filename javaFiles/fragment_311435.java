class OuterClass {

     double doubx;
     double douby;
     double doubz;

     void method {
     String accval = text;
         try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(
                new FileWriter("sdcard/YS Data/Accelerometer.html",
                        true)));

            .....

            doubx = Double.parseDouble(x);
            douby = Double.parseDouble(y);
            doubz = Double.parseDouble(z);

            writer.println("<h3 style=padding-left:20px;>" + "x is "
                  + doubx + "<br>" + "y is " + douby + "<br>"
                  + "Force is " + doubz + "</h3><br>");

            writer.close();
        } catch (IOException e) {
           /** notification possibly */
           e.printStackTrace();
        }
     }

     protected class Update extends AsyncTask<Context, Integer, String> {

         .....

     }
}