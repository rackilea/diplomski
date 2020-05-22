public class ListadoPedidos {

private static volatile ArrayList<Pedido> pedidos=new ArrayList<>();

public ListadoPedidos() {

}
/**
 * Here DO NOT return the arrayList. The underlying implementation is not threadsafe
 */
//    public  ArrayList<Pedido> getPedidos() {
//        return pedidos;
//    }

public synchronized void addPedidos(Pedido pedido) {
    pedidos.add(pedido);
}

public synchronized int Contar(int o) {
    int n=0;
    for (Pedido p: pedidos) {
        if (p.getNro_operario()==o) {
            n++;
        }
    }
    return n;
}


public synchronized Pedido TraerNuevo(int o, int c) {
    int n=0;
    Pedido nuevo = new Pedido();
    for (Pedido p: pedidos) {
        if (p.getNro_operario()==o) {
            n++;
        }
        if (n==c) {
            nuevo=p;break;
        }
    }
    return nuevo;
}

}