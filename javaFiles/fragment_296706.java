out = new FileOutputStream("Project1.txt");
Formatter fmt = new Formatter(out);
fmt.format("%12s %12s %12s %12s %12s %12s%n", 
    "Algorithm", "n", "time", "time/n^3", "time/n^2", "time/(n*log(n))");
fmt.format("%12s %12s %12s %12s %12s %12s%n%n", 
    "_________", "_", "(ms)", "x100,000", "x10,000", "x10,000");

...
fmt.flush();
out.close();