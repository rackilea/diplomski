@Bean FastDateFormat fastDateFormat() {
  return new FastDateFormat("yyyy/MM/dd");
}

@Bean String currentDate() = {
  return fastDateFormat().format(new Date());
}