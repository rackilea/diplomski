RList l = c.eval("{ res <- AnomalyDetectionTs(data, direction='both', plot=FALSE,
                          longterm=TRUE)$anoms;
                  list(as.POSIXct(res$timestamp), res$anoms) }").asList();
double ts[] = l.at(0).asDoubles();
double anom[] = l.at(1).asDoubles();
for (int i = 0; i < ts.length; i++)
    System.out.println(new java.util.Date((long)(ts[i]*1000.0)) + ": " + anom[i]);