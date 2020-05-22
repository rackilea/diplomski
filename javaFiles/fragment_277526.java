ObjectMap<String, MyAnimation> animationsByNames = new ObjectMap<String, MyAnimation>();
animationsByNames.put(
        "heroWithoutClothes",
        new MyAnimation(0, 0, heroWidth, heroHeight, frameDuration, heroKeyframes)
);
animationsByNames.put(
        "underwear",
        new MyAnimation(underwearOffsetX, underwearOffsetY,underwearWidth, underwearHeight, frameDuration, underwearKeyframes)
);
//etc...