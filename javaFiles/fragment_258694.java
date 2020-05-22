int sum = 0;
for (IntWritable val : values) {
  sum += val.get();
}
result.set(sum);
context.write(key, result);