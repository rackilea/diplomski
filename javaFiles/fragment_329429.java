Scanner userInput = new Scanner(System.in);
System.out.println("Enter a value to represent the radius of a circle.");
String radius = userInput.next();
float radiusValue = Float.parseFloat(radius);

float area = Math.round(((float) (Math.PI * radiusValue * radiusValue)) * 10F) / 10F;
float circumference = Math.round(((float) (2F * Math.PI * radiusValue)) * 10F) / 10F;