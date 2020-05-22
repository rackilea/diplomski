@Override
public void setCapacity(   int capacity   ) { --> **adding this argument here will fix the issue.**
    super.print();
    System.out.println("Cannot change capacity of a car");
}

public void setCapacity(int setCapacity) {
    this.capacity = setCapacity;
    System.out.println("New Capacity = " + setCapacity);
}