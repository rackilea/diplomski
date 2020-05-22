public class PassReferenceTypeParamenterByValue {

        public static void main (String []args){
            PointForPassReferenceTypeParametersByValue p = new PointForPassReferenceTypeParametersByValue(2, 3);
            System.out.println("The new X and Y postions of the point P after it has been moved by the method p.moveP() are X: " + moveP(p).xPosition + " and Y: " + moveP(p).yPosition + ".");
        }

        public static PointForPassReferenceTypeParametersByValue moveP(PointForPassReferenceTypeParametersByValue del_p){
            del_p.xPosition=10;
            del_p.yPosition=20;
            del_p = new PointForPassReferenceTypeParametersByValue(del_p.xPosition, del_p.yPosition);
            return del_p;
        }
    }

    /* Make sure to understand the difference class types
     * 
     * With "pulbic class...." you create a Top-Level class ("normal" java class) which has to reside in its own .java file 
     * So if you want to create a "public class MyClass" it MUST reside in a file MyClass.java. 
     * 
     * If you however want to define multiple classes whithin the same .java file what you need is a so called nested top level 
     * class. It is basicially the same like a top-level class except it is not stored within a own .java file with the same name 
     */
    class PointForPassReferenceTypeParametersByValue {
        int xPosition;
        int yPosition;
        PointForPassReferenceTypeParametersByValue(int x, int y){
            xPosition=x;
            yPosition=y;
        }

    }