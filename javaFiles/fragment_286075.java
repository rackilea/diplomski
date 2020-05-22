boolean more = rs.next();

if (!more) {
    out.println("NOK: result set is not available");
} else {
    while (more) {
        out.write("OK: result is available");
  .......
  
  more = rs.next();
    }
}