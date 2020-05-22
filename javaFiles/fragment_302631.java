public class ArrayWrapper { 
       private Object[]array; 
       public ArrayWrapper(Object[] array) { this.array = array; } 
       public Object[] getArray() { 
                 Object[] newArray=new Object[array.length]; 
                 System.arraycopy(array,0,newArray,0,array.length); 
                  return newArray; 
       } 
       public int hashCode() { return Arrays.hashCode(array); } 
       public boolean equals(Object obj) { 
              boolean b=false;
              if(obj instanceof ArrayWrapper){ 
                     b=Arrays.equals(this.array,((ArrayWrapper)obj).getArray()); 
              } 
              return b; 
       } 
 }