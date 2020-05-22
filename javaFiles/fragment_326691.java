ps=con.prepareStatement("update patient set sname=?, address=?, bloodgrp=?, history=?, roomtype=?, roomno=?, contact=?, doa=?.................);
ps.setString(1,s1);

...
..
.

ps.executeUpdate();