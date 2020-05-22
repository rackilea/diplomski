import java.util.*;
class Student implements Comparable<Student> {
   public String str;   
   public int  marks;

   public Student( String s, int m ) { 
     this.str = s;
     this.marks = m;
   }
   public int compareTo( Student other ) { 
    return other.marks - this.marks;
   }
   public String toString() { 
     return String.format("Student(str=%s,marks=%s)", str, marks);
   }

}
class Main { 
  public static void main( String ... args ) { 
    List<Student> l;
    Collections.sort(( l =  new ArrayList<Student>(Arrays.asList(
      new Student("sub3", 2),
      new Student("sub1", 10),
      new Student("sub2", 5)
    ))));
    System.out.println( l );
  }
}


C:\>java Main
[Student(str=sub1,marks=10), Student(str=sub2,marks=5), Student(str=sub3,marks=2)]