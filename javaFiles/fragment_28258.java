public static void main(String[] args) throws IOException {
    String content = "String name = carrot;\ndouble unit_price = 200;\nint unit = 10;";
    try (Scanner sc = new Scanner(content)) {
        sc.useDelimiter("(;*\n*.+ .+ = )|;");
        List<Incredient> incredients = new ArrayList<>();
        while (true) {
            Incrediend incredient = new Incredient();
            if (sc.hasNext()) {
                String name = sc.next();
                incredient.setName(name);
                System.out.println("Name: " + name);
            } else {
                break;
            }
            if (sc.hasNextDouble()) {
                double unitPrice = sc.nextDouble();
                incredient.setUnit_price(unitPrice);
                System.out.println("Unit Price: " + unitPrice);
            } else {
                break;
            }
            if (sc.hasNextInt()) {
                int unit = sc.nextInt();
                incredient.setUnit(unit);
                System.out.println("Unit: " + unit);
            } else {
                break;
            }
            incredients.add(incredient);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}