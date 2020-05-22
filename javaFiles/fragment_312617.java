line(
    img_matches,
    new Point(
        img_object.cols() + scene_corners.get(0).x,
        0 + scene_corners.get(0).y),
    new Point(
        img_object.cols() + scene_corners.get(1).x,
        0 + scene_corners.get(1).y),
    Scalar(0, 255, 0),
    4
);