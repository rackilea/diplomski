for (double v : vals) max = Math.max(max, v);
Arrays.sort(vals);
System.out.println("value at vals[0] c "+vals[0]);
double min=vals[0];
int m2=(int) Math.round(min);
int m3=(int) Math.round(max);

**int bucketCount = 1+((m3-m2)/10);
double[] bucket =new double[bucketCount];
double[][] buckets = new double[bucketCount][3];**