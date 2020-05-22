String sql = "SELECT SUM(TIME_TO_SEC(ot))"
            + " FROM attendance"
            + " WHERE department = '"+department+"'"
            + " AND date BETWEEN '"+dateChooser1+"' AND '"+dateChooser2+"'";
    st = con.createStatement();
    rst = st.executeQuery(sql);
    if(rst.next())
    {
            String time = rst.getString(1);
            Double dTime = Double.valueOf(time);
            int intTime = (int) dTime.doubleValue();
            String nTime = calculateTime(intTime);
            oTimeTemp.setText(nTime);
    }

private static String calculateTime(int totalSecs)
{
    int hours = totalSecs / 3600;
    int minutes = (totalSecs % 3600) / 60;
    int seconds = totalSecs % 60;

    String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
    return timeString;
}