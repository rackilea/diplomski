package
{
    import com.display.Ball;
    import flash.display.Sprite;
    import flash.events.MouseEvent;

    public class Main extends Sprite
    {
        private var _balls:Array;

        public function Main()
        {
            init();

        }// end function

        private function init():void
        {
            _balls = new Array();

            stage.addEventListener(MouseEvent.CLICK, onStageMouseClick);

        }// end function

        private function onStageMouseClick(e:MouseEvent):void
        {
            createBall(e.stageX, e.stageY); 

        }// end function

        private function createBall(p_x:Number, p_y:Number):void
        {
            var ball:Ball = new Ball(p_x, p_y);
            addChild(ball);
            _balls.push(ball);

        }// end function

    }// end class

}// end package