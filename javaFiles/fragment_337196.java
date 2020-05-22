class BoundToRectangle {
  constructor(rectangle) {
    this.rectangle = rectangle
  }

  bound(point, size) {
    const calcPoint = point.clone()
    const rectP2 = this.rectangle.getP3()

    if (this.rectangle.position.x > calcPoint.x) {
      (calcPoint.x = this.rectangle.position.x)
    }
    if (this.rectangle.position.y > calcPoint.y) {
      calcPoint.y = this.rectangle.position.y
    }
    if (rectP2.x < calcPoint.x + size.x) {
      calcPoint.x = rectP2.x - size.x
    }
    if (rectP2.y < calcPoint.y + size.y) {
      calcPoint.y = rectP2.y - size.y
    }

    return calcPoint
  }
}