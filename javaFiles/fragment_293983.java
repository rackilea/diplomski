public class PassReferenceTypeParamenterByValue {

        public static void main (String []args){
            MyPoint p = new MyPoint(2, 3);
            //We already use the get/ set methods rather to "rape" your new MyPoint object by directly calling its member variables
            System.out.println("The new X and Y postions of the point P after it has been moved by the method p.moveP() are X: " + moveP(p).getXPosition() + " and Y: " + moveP(p).getYPosition() + ".");
        }

        public static MyPoint moveP(MyPoint del_p){
            del_p.setXPosition(10);
            del_p.setYPosition(20);
            del_p = new MyPoint(del_p.getXPosition(), del_p.getYPosition());
            return del_p;
        }
    }


    /* We call this MyPoint just because the sun is shining bright outside here in switzerland (teaching you how to name things properly 
     * exceeds the bounds of my answer right now. 
     */
    class MyPoint {
        /* Encapsulation: You dont want other classes to directly access your class members (variables) so you define those 
         * as private. Thus to allow other classes to access those private members you provide get/set Methods. Go read about
         * the java bean naming convention of bean propertys and the according get/ set methods right now and make sure to always
         * use that naming pattern in the future (since tonns of frameworks youre maybe using in the future will rely on you following 
         * those standards
         */
        private int xPosition;
        private int yPosition;

        MyPoint(int x, int y){
            xPosition=x;
            yPosition=y;
        }

        /* You dont want to have that for any variable in general but for those that should be accessable (indirectly) from 
         * outside your code. 
         */
        public void setXPosition(int xPosition){
            /* Because you now have two variables (read about visibility of different variable types) with the same name you have 
             * to clearify which of both you mean. By adding 'this' you tell the compiler youre talking about the variable of the
             * object rather than the local one of this method. 
             */

            this.xPosition = xPosition;
        }

        public int getXPosition(){
            /* Here you dont need the 'this' because there is no other local variable with the same name, you can however always 
             * make that clearification so "return this.xPosition" is equal in that case. 
             */
            return xPosition;
        }

        //The same for the yPosition value:
        public void setYPosition(int yPosition){
            this.yPosition = yPosition;
        }

        public int getYPosition(){
            //like told above 'return this.yPosition' is equal to 'return yPosition'
            return this.yPosition;
        }

    }