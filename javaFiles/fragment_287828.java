for(int i = 0; i < clientes.length; i++) {
    if(clientes[i].getMarcaCelular().equals("Motorola")){
        System.out.println(
            clientes[i].getNombre() + " , " + 
            clientes[i].getCedulaIdentidad()
        );
        break;
    }
}