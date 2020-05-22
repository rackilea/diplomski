private static final Map<String, Integer> COLORMAP = new HashMap<>();
static {
    COLORMAP.put("BLACK", 0);
    COLORMAP.put("BROWN", 1);
    COLORMAP.put("RED", 2);
    COLORMAP.put("ORANGE", 3);
    COLORMAP.put("YELLOW", 4);
    COLORMAP.put("GREEN", 5);
    COLORMAP.put("BLUE", 6);
    COLORMAP.put("VIOLET", 7);
    COLORMAP.put("GREY", 8);
    COLORMAP.put("WHITE", 9);
}

/* ... */

f_resist[cnt1] = COLORMAP.get(f_wordcolor[cnt1]);