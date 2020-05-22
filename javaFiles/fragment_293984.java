public class PassReferenceTypeParamenterByValue {

        public static void main (String []args){
            MyPoint p = new MyPoint(2, 3);

            System.out.println("The new X and Y postions of the point P after it has been moved by the method p.moveP() are X: " + moveThePointYouDeliverMe(p).getXPosition() + " and Y: " + moveThePointYouDeliverMe(p).getYPosition() + ".");

            System.out.println("The new X and Y postions of the new point P after it has been created by the method p.moveP() are X: " + moveThePointYouDeliverMe(p).getXPosition() + " and Y: " + moveThePointYouDeliverMe(p).getYPosition() + ".");

        }

        /* If you just want to move a point and not create a new, independent (of the one delivered) one you 
         * can just use the set-methods of that point, modify its values and return the updated point.
         * This will best match your above System-out which indicates you still have the same Point object you delivered to that method.
         */
        public static MyPoint moveThePointYouDeliverMe(MyPoint del_p){
            del_p.setXPosition(10);
            del_p.setYPosition(20);
            return del_p;
        }

        /* If you dont want to change the object delivered to your method but rather return a new, independent object
         * your previous approach comes in with a little modification so you dont change the state of the delivered object
         */    
        public static MyPoint copyAndMoveThePointDeliveredMe(MyPoint del_p){
            return new MyPoint(10, 20);
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