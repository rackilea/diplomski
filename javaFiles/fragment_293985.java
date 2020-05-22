public class PassReferenceTypeParamenterByValue {

        public static void main (String []args){

            MyPoint p = new MyPoint(2, 3);

            System.out.println("Created a Point with coordinates X="+p.getXPosition()+" , Y+"+p.getYPosition());

            int newXPos = 20;
            int newYPos = 10;

            System.out.println("Moving the Point to the new coordinates X="+newXPos+" , Y="+newYPos);

            /* Since you already have a reference 'p' to your point and know that your move-method wont change the reference (e.g. create and return a new 
             * Point Object. you can just call this method without storing the same reference:
             */
            moveThePointYouDeliverMe(p, newXPos, newYPos);

            System.out.println("The point was moved! New coordinates: X="+p.getXPosition()+" , Y+"+p.getYPosition());           

        }

        /* We now allow the outerworld to tell  us where to move that point to.
         */
        public static MyPoint moveThePointYouDeliverMe(MyPoint del_p, int newXPosition, int newYPosition){
            del_p.setXPosition(newXPosition);
            del_p.setYPosition(newYPosition);
            return del_p;
        }

        /* We dont need such a method because the outerworld can already create the same result by directly calling 
         * the constructor of MyPoint providing the values of x/y to the constructor
         * 
         * So delte this comment and this method 
         */    
        /*public static MyPoint copyAndMoveThePointDeliveredMe(MyPoint del_p, int newXPosition, int newYPosition){
            return new MyPoint(newXPosition, newYPosition);
        }*/
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