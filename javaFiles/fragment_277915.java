String objectType = in.next();
String name = in.next();
int x = in.nextInt();
int y = in.nextInt();
int z;
if("Dog".equals(objectType)) {
    z = in.nextInt();
}
String colour = in.next();
int ID = in.next();

if("Dog".equals(objectType)) {
    Dog newDog = new Dog(name, x, y, z, colour, ID);
}