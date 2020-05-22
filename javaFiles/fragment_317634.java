package com.display
{
    import flash.display.Sprite;

    public class Ball extends Sprite
    {
        private var _radius:Number = 50;
        private var _x:Number;
        private var _y:Number;
        private var _color:uint = 0xFF0000; // red

        public function Ball(p_x:Number, p_y:Number)
        {
            _x = p_x;
            _y = p_y;

            init();

        }// end function

        public function init():void
        {
            draw();

        }// end function

        public function draw():void
        {
            this.graphics.beginFill(_color);
            this.graphics.drawCircle(_x, _y, _radius);
            this.graphics.endFill();

        }// end function

    }// end class

}// end package