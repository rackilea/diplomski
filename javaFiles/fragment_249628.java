public static class GF extends SomeForm<GF> {
}

public static void main(String[] args) {
    ZMyCheck<GF, ZMyUnit<GF, AuxFF<GF>>> z = new ZMyCheck<>();
    z.unit = new ZMyUnit<>();
    z.f();
    System.out.println("OK");
}