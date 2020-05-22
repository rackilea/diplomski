public interface Locatable {
    public void setX(int x);
    public void setY(int y);

    public int getX();
    public int getY();
}

public class Way implements Locatable {
    ...
}

public class Pavement implements Locatable {
    ...
}

List<Locatable> locatables = new ArrayList<Locatable>();
list.add(new Way());
list.add(new Pavement());
for (Locatable locatable: locatables) {
    locatable.setX(22);
    locatable.setY(43);
}

for (Locatable locatable: locatables) {
    System.out.println("the locatable is an instance of " + locatable.getClass());
    System.out.println("its location is " + locatable.getX() + ", " + locatable.getY());

}