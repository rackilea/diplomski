SimpleDateFormat sdf = new SimpleDateFormat("MMM d ss, yyyy 'at' hh:mma z");

String f = sdf.format(1435271907000L);
Date d = sdf.parse(f);

System.out.println(d.getTime() == 1435271907000L);