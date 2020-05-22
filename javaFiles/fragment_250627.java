public class Polynomial {

    Map<Integer, Object> polynomial;

    public Polynomial() {
        polynomial = new HashMap<>();
    }

    public Polynomial(int numberOfMembers) {
        polynomial = new HashMap<>(numberOfMembers);
    }

    public void addElm(int power, int coefficient) {
        if (power < 0) {
            power = Math.abs(power);
            throw new RuntimeException("ERROR: The power must be an absolute number, converting to absolute");
        }
        for (Entry<Integer, Object> m : polynomial.entrySet()) {
            if ((Integer) m.getKey() == power) {
                polynomial.put(power, m.getValue());
            }
        }
    }

}