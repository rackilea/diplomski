private function log(t:Number):Number {
        return 1 / (1 + Math.pow(Math.E, -t));
    }

    private function transformVertex(vertex:Vector3D, controlPoint:Vector3D):Vector3D {

        // get control point relative to center of influence
        // (this could actually be calculated in pre-processing, as
        // it doesn't change between vertices)
        var controlPointRel:Vector3D = controlPoint.subtract(CENTER);

        // get vertex relative to center of influence
        var rel:Vector3D = vertex.subtract(CENTER);

        // get distance of vertex from center
        var dst:Number = rel.length / RADIUS;
        if (dst > 1) return vertex; // vertex outside circle of influence


        // PULL TO CONTROL POINT

        // tScale controls the steepness of the transition from the
        // edge of the circle. 1 = logistic transition, >1 = steeper
        var tScale:Number = 1.7;
        var t:Number = (1 - dst) * 12 * tScale - 6; // [-6, 6]
        t = log(t);

        controlPointRel = controlPointRel.clone();
        controlPointRel.scaleBy(t);
        // ALTERNATIVE, try this too:
        // controlPointRel.scaleBy(t * (1 - dst));

        rel = rel.add(controlPointRel);

        // relative to absolute
        return rel.add(CENTER);

    }