void MainScene::CreateBody()
{
   Vec2 position(0,0);

   // Create the body.
   b2BodyDef bodyDef;
   bodyDef.position = position;
   bodyDef.type = b2_dynamicBody;
   _body = _world->CreateBody(&bodyDef);
   assert(_body != NULL);

   // Now attach fixtures to the body.
   FixtureDef fixtureDef;
   PolygonShape polyShape;
   vector<Vec2> vertices;

   const float32 VERT_SCALE = .5;
   fixtureDef.shape = &polyShape;
   fixtureDef.density = 1.0;
   fixtureDef.friction = 1.0;
   fixtureDef.isSensor = false;

   // Main Box
   vertices.clear();
   vertices.push_back(Vec2(1*VERT_SCALE,1*VERT_SCALE));
   vertices.push_back(Vec2(-1*VERT_SCALE,1*VERT_SCALE));
   vertices.push_back(Vec2(-1*VERT_SCALE,-1*VERT_SCALE));
   vertices.push_back(Vec2(1*VERT_SCALE,-1*VERT_SCALE));
   polyShape.Set(&vertices[0],vertices.size());
   _body->CreateFixture(&fixtureDef);
   _fixturePositions.push_back(CalculateAverage(vertices));

   // Down one
   vertices.clear();
   vertices.push_back(Vec2(1*VERT_SCALE,-1*VERT_SCALE));
   vertices.push_back(Vec2(-1*VERT_SCALE,-1*VERT_SCALE));
   vertices.push_back(Vec2(-1*VERT_SCALE,-3*VERT_SCALE));
   vertices.push_back(Vec2(1*VERT_SCALE,-3*VERT_SCALE));
   polyShape.Set(&vertices[0],vertices.size());
   _body->CreateFixture(&fixtureDef);
   _fixturePositions.push_back(CalculateAverage(vertices));

   // Up One
   vertices.clear();
   vertices.push_back(Vec2(1*VERT_SCALE,3*VERT_SCALE));
   vertices.push_back(Vec2(-1*VERT_SCALE,3*VERT_SCALE));
   vertices.push_back(Vec2(-1*VERT_SCALE,1*VERT_SCALE));
   vertices.push_back(Vec2(1*VERT_SCALE,1*VERT_SCALE));
   polyShape.Set(&vertices[0],vertices.size());
   _body->CreateFixture(&fixtureDef);
   _fixturePositions.push_back(CalculateAverage(vertices));

   // T Left Top
   vertices.clear();
   vertices.push_back(Vec2(-1*VERT_SCALE,3*VERT_SCALE));
   vertices.push_back(Vec2(-3*VERT_SCALE,3*VERT_SCALE));
   vertices.push_back(Vec2(-3*VERT_SCALE,1*VERT_SCALE));
   vertices.push_back(Vec2(-1*VERT_SCALE,1*VERT_SCALE));
   polyShape.Set(&vertices[0],vertices.size());
   _body->CreateFixture(&fixtureDef);
   _fixturePositions.push_back(CalculateAverage(vertices));

   // T Right Top
   vertices.clear();
   vertices.push_back(Vec2(3*VERT_SCALE,3*VERT_SCALE));
   vertices.push_back(Vec2(1*VERT_SCALE,3*VERT_SCALE));
   vertices.push_back(Vec2(1*VERT_SCALE,1*VERT_SCALE));
   vertices.push_back(Vec2(3*VERT_SCALE,1*VERT_SCALE));
   polyShape.Set(&vertices[0],vertices.size());
   _body->CreateFixture(&fixtureDef);
   _fixturePositions.push_back(CalculateAverage(vertices));

   _body->SetAngularVelocity(M_PI/8);
}