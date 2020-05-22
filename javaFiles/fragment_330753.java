public class test {
    // ...
    static List<String> data = new ArrayList<String>();
    // ...
    public void serialEvent(SerialPortEvent event) {
        try {
            String getdata =  serialPort.readString(event.getEventValue());
            // String.split takes a regular expression. In regular expressions,
            // the dollar sign ($) by it's own means the end of the line, so you
            // have to escape it using a backslash (\), but since it's a string
            // you have to escape that one with another backslash so it get's
            // passed correctly, thus searching for the dollar sign and not the
            // end of the line
            String[] parts = getdata.split("\\$");
            // Append whatever is before the first dollar sign to the last item
            // in your data
            if(!data.isEmpty()){
                data.set(data.size() - 1, data.get(data.size() - 1) + parts[0]);
            }
            // Append the rest of the parts in your data
            for (int i=1; i<parts.length; i++) {
                data.add(parts[i]);
            }
        }
        catch (SerialPortException ex) {}
        // ...
    }
    // ...
}