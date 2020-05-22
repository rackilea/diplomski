public class SecretCombination {

    public int codeLength = 4;

    public Random random = new Random();

    public Color[] PossibleColors = { Color.RED, Color.green, Color.blue, Color.yellow, Color.PINK, Color.BLACK };
    public List<Color> colorList = new ArrayList<Color>(Arrays.asList(PossibleColors));

    public Color[] SecretColorCombi = new Color[codeLength];

    public SecretCombination() {
        for (int i = 0; i < codeLength; i++) {
            int randIndex = random.nextInt(colorList.size());
            Color randColor = colorList.remove(randIndex);
            System.out.println("Length: " + colorList.size() + ", Color Picked: " + randColor);
            SecretColorCombi[i] = randColor;
        }
    }

    public static void main(String args[]) {
        SecretCombination secretCombination = new SecretCombination();
        Stream.of(secretCombination.SecretColorCombi).forEach(System.out::println);
    }

}