import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public IntArray {

 private int[] ints;

 public IntArray() {}

 public IntArray(int[] ints) {
  this.ints = ints;
 }

 public int[] getInts() {
  return ints; 
 } 
 ...
}