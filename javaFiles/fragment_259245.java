void MainScene::UpdateSprites()
{
   for(int idx = 0; idx < _fixturePositions.size(); idx++)
   {
      CCPoint spritePosition = Viewport::Instance().Convert(_body->GetWorldPoint(_fixturePositions[idx]));
      _fixtureSprites[idx]->setPosition(spritePosition);
      float32 bodyAngle = _body->GetAngle();
      bodyAngle = MathUtilities::AdjustAngle(bodyAngle);
      _fixtureSprites[idx]->setRotation(-CC_RADIANS_TO_DEGREES(bodyAngle));
   }
}