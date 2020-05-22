public class PassReferenceTypeParamenterByValue {

        public static void main (String []args){

            MyPoint p = new MyPoint(2, 3);

            System.out.println("Created a Point with coordinates X="+p.getXPosition()+" , Y+"+p.getYPosition());

            int newXPos = 20;
            int newYPos = 10;

            System.out.println("Moving the Point to the new coordinates X="+newXPos+" , Y="+newYPos);

            p.moveMe(newXPos, newYPos);

            System.out.println("The point was moved! New coordinates: X="+p.getXPosition()+" , Y+"+p.getYPosition());           

        }
    }

    class MyPoint {

        private int xPosition;
        private int yPosition;

        MyPoint(int x, int y){
            xPosition=x;
            yPosition=y;
        }

        /* Like polite people polite programms ask things to move rather to just move them away not because the result differs 
         * but the way you got to the result :) 
         */
        public void moveMe(int newXPos, int newYPos){
            /*We own those variables, we have the exclusive right to directly modify those values and are the only ones that dont 
             * need to call the set/get Methods for this
             */
            this.xPosition = newXPos;
            this.yPosition = newYPos;
        }

        public void setXPosition(int xPosition){
            this.xPosition = xPosition;
        }

        public int getXPosition(){
            return xPosition;
        }

        public void setYPosition(int yPosition){
            this.yPosition = yPosition;
        }

        public int getYPosition(){
            return this.yPosition;
        }

    }