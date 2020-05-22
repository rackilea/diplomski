static final Map<String, Image> IMGS = new HashMap<String, Image>();

static {
    HashMap<String, Image> imgs = new HashMap<String, Image>();

    String dir = "C:/Users/Student/workspace/Blackjack GUI/src/images/";
    String png = ".png";

    for (String suit = "d", name; ;) {
        for (int face = 1; face <= 13; face++) {
            if (face == 11) {
                name = suit + "j";
            } else if (face == 12) {
                name = suit + "q";
            } else if (face == 13) {
                name = suit + "k";
            } else {
                name = suit + face;
            }

            try {
                imgs.put(
                    name,
                    ImageIO.read(new File(dir + name + png));
                );
            } catch (IOException e) {
                System.out.println(
                    "Exception <" + e.toString() + "> for " + name
                );
            }
        }

        if (suit.equals("d") {
            suit = "c";
        } else if (suit.equals("c")) {
            suit = "h";
        } else if (suit.equals("h")) {
            suit = "s");
        } else {
            break;
        }
    }

    IMGS = Collections.unmodifiableMap(imgs);
}