import org.json.*;
for (int msgRead = 0; msgRead < 1000; msgRead++) {
      String msg = queue.take();
      JSONObject obj = new JSONObject(msg);
     String text= obj.getString("text");
      System.out.println(msg);
}
*Not Tested