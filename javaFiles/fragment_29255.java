package Bag;

import bag.USet;
import java.util.Iterator;

public class Bag implements USet<Integer> {

  @Override
  public Iterator<Integer> iterator() {
    System.out.println("iterator called.");
    return null;
  }

  @Override
  public int size() {
    System.out.println("size called.");
    return 0;
  }

  @Override
  public boolean add(Integer x) {
    System.out.println("add called with " + x);
    return false;
  }

  @Override
  public Integer remove(Integer x) {
    System.out.println("remove called with " + x);
    return null;
  }

  @Override
  public Integer find(Integer x) {
    System.out.println("find called with " + x);
    return null;
  }

  @Override
  public void clear() {
    System.out.println("clear called ");
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here
    Bag myBag = new Bag();
    myBag.add(1);
    myBag.add(2);
    myBag.add(3);
    int size = myBag.size();
  }

}