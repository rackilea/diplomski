@Override
public String estadoPedido(List<DetallePedido> lista) { 
    EntityManager em = emf.createEntityManager();
    //em.getTransaction().begin(); //Consider using Container managed transactions ,
    // if you do remove this line and the line above, and have
    //entity manager injected ! 
    String mensage = null;
    try { 
         for (DetallePedido ped : lista) { 
            detPed.setPedEstado("EN PLAN"); 
            em.merge(detPed); 
         } 
         mensage = "detalle seleccionado"; 
         em.getTransaction().commit; //consider removing this line and use Container managed transactions! 
    } catch (Exception e)  { 
         mensage = "Error:/p" + e.getMessage(); 
    } finally{ 
       em.close(); 
    } 
    return mensage; 
}