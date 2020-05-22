NumberFormat format = NumberFormat.getInstance();

StringBuilder sb = new StringBuilder();
long maxMemory = runtime.maxMemory();
long allocatedMemory = runtime.totalMemory();
long freeMemory = runtime.freeMemory();

sb.append("free memory: " + format.format(freeMemory / 1024) + "<br/>");
sb.append("allocated memory: " + format.format(allocatedMemory / 1024) + "<br/>");
sb.append("max memory: " + format.format(maxMemory / 1024) + "<br/>");
sb.append("total free memory: " + format.format((freeMemory + (maxMemory - allocatedMemory)) / 1024) + "<br/>");