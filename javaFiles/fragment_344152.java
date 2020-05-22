public static Empleado retornaEmpleadoMayorSueldo(List<Empleado> lista) {
    return Collections.max(lista, new Comparator<Empleado >() {
               @Override
               public int compare(Empleado e1, Empleado e2) {
                   return e1.getSueldo().compareTo(e2.getSueldo()));
               }
           });
}