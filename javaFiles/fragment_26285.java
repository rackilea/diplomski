package gen;

class Genotype {

    Object value;
    float weight;

    public Genotype(int value, float weight) {
        System.out.println("Genotype.Genotype");
    }

    public Genotype(int[] value, float weight) {
        System.out.println("Genotype.Genotype");
    }

    public Genotype(String value, float weight) {
        System.out.println("Genotype.Genotype");
    }

    public Genotype(float value, float weight) {
        System.out.println("Genotype.Genotype");
    }

    public Object getValue() {
        System.out.println("Genotype.getValue");
        return null;
    }

    public void setValue(String value) {
        System.out.println("Genotype.setValue");
    }

    public void setValue(float value) {
        System.out.println("Genotype.setValue");
    }

    public void setValue(int value) {
        System.out.println("Genotype.setValue");
    }

    public void setValue(int[] value) {
        System.out.println("Genotype.setValue");
    }

    public float getWeight() {
        System.out.println("Genotype.getWeight");
        return 0;
    }
}