String dd = request.getParameter("pcdd");
String mm = request.getParameter("pcmm");
String yyyy = request.getParameter("pcyy");
String dateStr = yyyy + "-" + mm + "-" + dd + " 00:00:00";

SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
java.util.Date utilDate = format.parse(dateStr);