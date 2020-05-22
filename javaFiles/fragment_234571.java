// Get the level drawable resource id
int imageRes = R.drawable.default_image;
switch (levelReached) {
    case LEVEL_ONE: // 1
        imageRes = R.drawable.level_one;
        break;
    case LEVEL_TWO: // 2
        imageRes = R.drawable.level_two;
        break;
    ...
}

// Set the drawable as a background
levelIndicatorImageView.setBackgroundResource(imageRes);