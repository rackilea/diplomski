public void NextPicture() {
    int[] signsArray = { R.drawable.no_parking, R.drawable.no_u_turn_sign, R.drawable.one_way_sign,
            R.drawable.pedestrian_crossing, R.drawable.speed_limit_sign, R.drawable.stop_sign,
            R.drawable.yield_sign };
    randomPicIndex = random.nextInt(7);
    signImage.setImageResource(signsArray[randomPicIndex]);
    signImage.setTag(tagArray.get(randomPicIndex));

}