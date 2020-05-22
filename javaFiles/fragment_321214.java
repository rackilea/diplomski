String cssvalue = webDriver.findElement(By.id(elementId)).getCssValue("color");
String [] s = cssvalue.split("rgb");
StringTokenizer st = new StringTokenizer(s[1], ",() ");
List<Integer> values = new ArrayList<Integer>();
int index=0;
while (st.hasMoreTokens()) {
  values.add(Integer.parseInt(st.nextToken()));
  log.info("TOken: "+values.get(index));
  index++;

}
Integer [] a = values.toArray(new Integer[3]);