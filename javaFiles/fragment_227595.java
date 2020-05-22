String time = request.getParameter("time");
Date date = null;

try {
    date = new SimpleDateFormat("HH:mm").parse(time);
}
catch (ParseException e) {
    request.setAttribute("time_error", "Please enter time in format HH:mm");
}