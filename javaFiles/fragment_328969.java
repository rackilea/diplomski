World world = new World(new Vec2(0, 0), true);
Body body = world.createBody(new BodyDef());

// Add a circle
CircleShape circle = new CircleShape();
circle.m_radius = 20;
body.createFixture(circle, 5);

// Add a box
PolygonShape rectangle = new PolygonShape();
rectangle.setAsBox(137, 42);
body.createFixture(rectangle, 10);

// Add a more complex polygon
PolygonShape polygon = new PolygonShape();
Vec2[] vertices = new Vec2[5];
vertices[0] = new Vec2(-1, 2);
vertices[1] = new Vec2(-1, 0);
vertices[2] = new Vec2(0, -3);
vertices[3] = new Vec2(1, 0);
vertices[4] = new Vec2(1, 1);
polygon.set(vertices, 5);
body.createFixture(polygon, 10);

checkOutTheseFixtures(body);