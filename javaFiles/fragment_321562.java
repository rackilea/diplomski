switch (findRotation()) {
    case Surface.ROTATION_0:
        params.height = 12; params.width = 600; params.x = 0; params.y = 1012;
        imageRes = R.drawable.horizontal; 
        break;
    case Surface.ROTATION_180: 
        params.height = 12; params.width = 600; params.x = 0; params.y = -1012;
        imageRes = R.drawable.horizontal; 
        break;
    case Surface.ROTATION_90: 
        params.height = 600; params.width = 12; params.x = 1012; params.y = 0;
        imageRes = R.drawable.vertical; 
        break;
    case Surface.ROTATION_270: 
        params.height = 600; params.width = 12; params.x = -1012; params.y = 0;
        imageRes = R.drawable.vertical; 
        break;
}