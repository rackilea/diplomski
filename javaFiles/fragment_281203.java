//your while loop
// if you have exact 3 cases, you can do this.
while ((line = in.readLine()) != null) {
    params = line.split("="); 
    if ("ro.device.name".equalsIgnoreCase(params[0])) {
        out.println(params[0] + "=" + "Galaxy Nexus"); 
    } else if ("ro.device.product".equalsIgnoreCase(params[0])) {
        out.println(params[0] + "=" + "some String"); 
    } else if ("ro.device.whatever".equalsIgnoreCase(params[0])) {
        out.println(params[0] + "=" + "another String"); 
    } else {
        out.println(line);
    }
}