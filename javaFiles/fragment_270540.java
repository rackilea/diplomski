// Check collisions
comprobarColisiones();

h.mover(pasadas); //Move hero

// Moving enemies
if (h.x > en.getX()){
    en.mover(h.getdx(), h.getIzq(),pasadas);
}
if (h.x> en2.getX()){
    en2.mover(h.getdx(), h.getIzq(),pasadas);
}

// Moving static objects (rocks)
roca1.mover(h.getdx(),h.getIzq());
roca2.mover(h.getdx(),h.getIzq());
roca3.mover(h.getdx(),h.getIzq());

// REPAINTING
repaint();

// A time calculation that I use to control the game speed somewhere
tiempoAnteriorTipito = System.currentTimeMillis();