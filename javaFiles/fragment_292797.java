import de.fhpotsdam.unfolding.*;
import de.fhpotsdam.unfolding.geo.*;
import de.fhpotsdam.unfolding.utils.*;
PGraphics mask, red;
color transparent = color(0);
color opaque = color(255);

UnfoldingMap map;

void setup() {
  size(800, 600, P2D);
  mask = createGraphics(width, height);
  red = createGraphics(width, height);

  map = new UnfoldingMap(this);
  map.zoomAndPanTo(new Location(52.5f, 13.4f), 10);
  MapUtils.createDefaultEventDispatcher(this, map);
}

void draw() {
  map.draw();
  PImage temp = get();

  //red
  red.beginDraw();
  red.tint(200,20,20);
  red.image(temp, 0, 0);
  red.endDraw();

  //mask

  mask.beginDraw();
  mask.noStroke();
  mask.background(opaque);
  mask.fill(transparent);
  mask.ellipseMode(CENTER);
  mask.ellipse(mouseX, mouseY, 200,200);
  mask.endDraw();

  // without this i'm not getting to call mask in red...
  // don't really know why, this is a workaround
  PImage redCasted = red.get();
  redCasted.mask(mask);

  image(redCasted, 0, 0);


}