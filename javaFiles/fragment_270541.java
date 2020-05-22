public void comprobarColisiones(){

    // Getting bounds
    Rectangle r1 = en.getBounds();
    Rectangle r2 = en2.getBounds();
    Rectangle rec_roca1 = roca1.getBounds();
    Rectangle rec_roca2 = roca2.getBounds();
    Rectangle rec_roca3 = roca3.getBounds();

    // Getting bounds and resolving collisions with shooting objects
    ArrayList martillos = Heroe.getMartillos();
    for (int i = 0; i < martillos.size(); i++) {

            Martillo m = (Martillo) martillos.get(i);
            Rectangle m1 = m.getBounds();
            if (r1.intersects(m1) && en.vive())
            {
                    en.setVive(false);
                    m.visible = false;
            }
            else if (r2.intersects(m1)&& en2.vive())
            {
                    en2.setVive(false);
                    m.visible = false;                        
            }
    }

    // Checking if hero touches enemies

    Rectangle heroecuad = h.getBounds();
    if (heroecuad.intersects(r1)&&en.vive()){
        perdio = true;
        System.out.println("PERDIO CON EL ENEMIGO 1");
    }
    if (heroecuad.intersects(r2)&&en2.vive()){
        perdio = true;
        System.out.println("PERDIO CON EL ENEMIGO 2");
    }

    // Checking if hero touches static objects

    if(heroecuad.intersects(rec_roca1)){
        System.out.println("CHOCO ROCA 1");
    }

    if(heroecuad.intersects(rec_roca2)){
        System.out.println("CHOCO ROCA 2");
    }        

    if(heroecuad.intersects(rec_roca3)){
        System.out.println("CHOCO ROCA 3");
    }        
}