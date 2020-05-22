StringBuilder buf = new StringBuilder();
for (Integer seat : list) {
    if (buf.length() != 0)
        buf.append(',');
    buf.append(seat);
}
ps.setString(8, buf.toString());
ps.executeUpdate();