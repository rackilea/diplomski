void MainScene::CreateSprites()
{
   Viewport& vp = Viewport::Instance();

   for(int idx = 0; idx < _fixturePositions.size(); idx++)
   {
      CCSprite* sprite = CCSprite::create("arrow.png");
       sprite->setScale(1.0*vp.GetPTMRatio()/128);
      _fixtureSprites.push_back(sprite);
      addChild(sprite);
   }
}