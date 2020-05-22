class ColorUtils{

public static final Map<String, int[]> COLOR_MAP;

static{
    COLOR_MAP = new HashMap<>();
    COLOR_MAP.put("red",  new int[]{255,0,0});
    COLOR_MAP.put("blue", new int[]{0, 0, 255});
    COLOR_MAP.put("green", new int[]{0, 255,0});
    ...
    ...   //add more colors here
}

public static double findDist(int[] rgb, int[] color){
    int deltaR = color[0] - rgb[0];
    int deltaG = color[1] - rgb[1];
    int deltaB = color[2] - rgb[2];
    return (Math.pow(deltaR, 2) + Math.pow(deltaG, 2) + Math.pow(deltaB, 2));
}

public static String findClosestColor(int[] rgb, Map<String, int[]> colorMap){
    int min = Integer.MAX_VALUE;
    String color = null;
    double dist;
    for(Entry<String, int[]> entry : colorMap.entrySet()){
        dist = findDist(rgb, entry.getValue());
        if(dist < min){
            dist = min;
            color = entry.getKey();
        }
    }
    return color;
}
}