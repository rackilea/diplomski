<?php

class Point {
    private $x;
    private $y;

    public function __construct($x, $y) {
        $this->x = $x;
        $this->y = $y;
    }

    public static function fromJSON($json) {
        //return json_decode($json);
        $obj = json_decode($json);
        return new Point($obj->x, $obj->y);
    }

    public function toJSON() {
        /*

        If you want to omit properties because of security, I think you will have to write this yourself.

        return json_encode(array(
            "x" => $this->x,
            "y" => $this->y
        ));

        You could easily do something like to omit x for example.

        $that = $this;
        unset($that->x);
        return json_encode(get_object_vars($that));

        */
        // Thank you http://stackoverflow.com/questions/4697656/using-json-encode-on-objects-in-php/4697749#4697749
        return json_encode(get_object_vars($this));
    }

    public function  __toString() {
        return print_r($this, true);
    }
}

$point1 = new Point(4,8);

$json = $point1->toJSON();
echo $json;
echo $point1;

$point2 = Point::fromJSON($json);
echo $point2;