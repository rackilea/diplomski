class Car {
...

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(this.aMaker);
    sb.append(",");
    sb.append(this.aModel);
    sb.append(",");
    sb.append(this.aYearBuilt);
    sb.append(",");

    return sb.toString();
  }
}

...

for (Car newCar : newCarDetails) {
  System.out.println(newCar.toString());
}