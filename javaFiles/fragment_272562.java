DateFormat f = new SimpleDateFormat("HH:mm:ss");
f.setTimeZone(TimeZone.getTimeZone("GMT"));
long startingTime = TimeUnit.HOURS.toMillis(5) + TimeUnit.MINUTES.toMillis(5);

public void actionPerformed(ActionEvent e) {
    long elapsed = System.currentTimeMillis() - startTimestamp;
    long displayTs = startingTime - elapsed;

    String out;
    if (displayTs >= 0) {
        out = f.format(new Date(displayTs));
    } else {
        out = "-" + f.format(new Date(-displayTs));
    }
    displayTimeLabel.setText(out);
}