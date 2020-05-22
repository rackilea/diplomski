Item item = itemsListVMenuVINOSespumosos.get(position);
if (MiPedidoActivity.itemsListVMiPedido.contains(item)) { // <- look for item!
   // ... item already in list
} else {
   MiPedidoActivity.itemsListVMiPedido.add(item);
}