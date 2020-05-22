import java.text.SimpleDateFormat;

Calendar timeOne = Server.getDateTime(itemArray.get(1).time)

SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm")

System.out.println(sdf.format(timeOne.getTime()))