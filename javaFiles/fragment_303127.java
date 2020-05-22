private enum Colour {
    WHITE,
    BLUE {
        @Override
        public String toString() {
            return "blue";
        }
    }
}

public static void main(String[] args) throws Exception {
    System.out.println(Arrays.toString(Colour.BLUE.getClass().getEnumConstants()));
    System.out.println(Arrays.toString(Colour.WHITE.getClass().getEnumConstants()));
    System.out.println(Arrays.toString(Colour.BLUE.getDeclaringClass().getEnumConstants()));
}