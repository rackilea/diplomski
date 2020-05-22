String stringLine = line.toString();
StringTokenizer stringTokenizer = new StringTokenizer(line, "\t");`

Put put = new Put(key.get());
put.add(family, column1,stringTokenizer.nextToken().getBytes());
put.add(family, column2,stringTokenizer.nextToken().getBytes());
put.add(family, column3,stringTokenizer.nextToken().getBytes());
put.add(family, column4,stringTokenizer.nextToken().getBytes());

try {
    context.write(new ImmutableBytesWritable(row), put);
} catch (InterruptedException e) {
    e.printStackTrace();
}