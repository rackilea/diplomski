String[] floatNumbers = {"42276880.0000", "48929200.0000","29723750.0000"};

for (String s: floatNumbers ) {
    Float temp = new Float(s);
    System.out.printf("%f\t", temp);
    System.out.println(temp);
}