package comecocos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Ghost1Thread extends Thread {

    int x;
    int y;
    Juego canvas;
    Ventana ventana;
    boolean pause;
    int[][] control;
    int anterior;
    int acelerar;
    Pacman pacman;
    int ignorar;
    int salir;
    /*AUMENTA DE VELOCIDAD CUANDO PACMAN COME VARIOS PUNTOS*/

    public Ghost1Thread(Juego canvas, Ventana ventana) {
        this.canvas = canvas;
        this.ventana = ventana;
        this.pacman = canvas.pacman;
        this.control = canvas.paredes;
        pause = true;
    }

    @Override
    public void run() {
        while(true) {
            mover();
            canvas.repaint();
            try {
                sleep(acelerar);
            } catch (InterruptedException ex) {
                System.out.println("Error durmiendo.");
            }
        }
    }

    public void mover() {
        if (!pause) {
            if (canvas.bolitas < 100 && canvas.g1.owned == false) {
                acelerar = 200;
            } else if ((canvas.bolitas < 100 && canvas.g1.owned == true) || (canvas.bolitas >= 100 && canvas.g1.owned == true)) {
                acelerar = 450;
            } else if (canvas.bolitas > 100 && canvas.g1.owned == false) {
                acelerar = 300;
            }
            if (canvas.g1.owned == false) {
                canvas.gh1[canvas.g1.y][canvas.g1.x] = 0;
                canvas.g1.x = buscar(canvas.pacman.x, canvas.pacman.y).x;
                canvas.g1.y = buscar(canvas.pacman.x, canvas.pacman.y).y;
                canvas.gh1[canvas.g1.y][canvas.g1.x] = 3;
            } else {
                if (canvas.pacman.x > canvas.g1.x) {
                    izquierda();
                } 
                if (canvas.pacman.x < canvas.g1.x) {
                    derecha();
                }
                if (canvas.pacman.y < canvas.g1.y) {
                    abajo();
                } 
                if (canvas.pacman.y > canvas.g1.y) {
                    arriba();
                }
            }
        }
    }

    public Casilla buscar(int x, int y) {
        this.x = x;
        this.y = y;
        Queue<Casilla> camino = new LinkedList<>();
        boolean [][] descubierto = new boolean[canvas.columnas][canvas.filas];
        int [][] distancias  = new int[canvas.columnas][canvas.filas];
        for (int i = 0; i < canvas.columnas; i++) {
            for (int j = 0; j < canvas.filas; j++) {
                descubierto[i][j] = false;
            }
        }
        for (int i = 0; i < canvas.columnas; i++) {
            for (int j = 0; j < canvas.filas; j++) {
                distancias[i][j] = 0;
            }
        }
        Casilla inicio = new Casilla(canvas.g1.x, canvas.g1.y, 3);
        Casilla fin = new Casilla(x, y, 2);
        inicio.distancia = 1;
        camino.add(inicio);
        while (!camino.isEmpty()) {
            Casilla actual = camino.remove();
            if (canvas.paredes[actual.y][actual.x] == canvas.paredes[fin.y][fin.x]) {
                fin = actual;
            }
            ArrayList<Casilla> lista = adyacente(actual);
            for (Casilla c : lista) {
                if (c.distancia == 0 && descubierto[c.x][c.y] == false) {
                    c.distancia = actual.distancia + 1;
                    descubierto[c.x][c.y] = true;
                    distancias[c.x][c.y] = c.distancia;
                    camino.add(c);
                }
            }
        }
        int dist = fin.distancia;
        camino.add(fin);
        while (!camino.isEmpty()) {
            Casilla actual = camino.remove();
            ArrayList<Casilla> lista = adyacente(actual);
            for (Casilla c : lista) {
                if (distancias[c.x][c.y] < dist) {
                    if (distancias[c.x][c.y] == 2){
                        return c;
                    } else {
                        dist = distancias[c.x][c.y];
                        descubierto[c.x][c.y] = false;
                        camino.add(c);
                    }
                }
            }
        }
        return fin;
    }

    public ArrayList<Casilla> adyacente(Casilla c) {
        ArrayList<Casilla> alrededor = new ArrayList<>();
        int ant;
        if (c.x > 0 && c.x < canvas.columnas - 1 && c.y > 0 && c.y < canvas.filas) {
            ant = canvas.paredes[c.y][c.x + 1];
            if ((ant != 7) && (ant != 8) && (ant != 9) && (ant != 11)
                    && (ant != 12) && (ant != 13) && (ant != 14) && (ant != 15)
                    && (ant != 16)) {
                alrededor.add(new Casilla(c.x + 1, c.y, 3));
            }
            ant = canvas.paredes[c.y][c.x - 1];
            if ((ant != 7) && (ant != 8) && (ant != 9) && (ant != 11)
                    && (ant != 12) && (ant != 13) && (ant != 14) && (ant != 15)
                    && (ant != 16)) {
                alrededor.add(new Casilla(c.x - 1, c.y, 3));
            }
            ant = canvas.paredes[c.y + 1][c.x];
            if ((ant != 7) && (ant != 8) && (ant != 9) && (ant != 11)
                    && (ant != 12) && (ant != 13) && (ant != 14) && (ant != 15)
                    && (ant != 16)) {
                alrededor.add(new Casilla(c.x, c.y + 1, 3));
            }
            ant = canvas.paredes[c.y - 1][c.x];
            if ((ant != 7) && (ant != 8) && (ant != 9) && (ant != 11)
                    && (ant != 12) && (ant != 13) && (ant != 14) && (ant != 15)
                    && (ant != 16)) {
                alrededor.add(new Casilla(c.x, c.y - 1, 3));
            }
        }
        return alrededor;
    }

    private void arriba() {
        anterior = canvas.paredes[canvas.g1.y - 1][canvas.g1.x];
        if ((anterior != 7) && (anterior != 8) && (anterior != 9) && (anterior != 11)
                && (anterior != 12) && (anterior != 13) && (anterior != 14) && (anterior != 15)
                && (anterior != 16) && noFantasma(canvas.gh1[canvas.g1.y - 1][canvas.g1.x],
                        canvas.gh2[canvas.g1.y - 1][canvas.g1.x],
                        canvas.gh3[canvas.g1.y - 1][canvas.g1.x],
                        canvas.gh4[canvas.g1.y - 1][canvas.g1.x])) {//Si no hay muro ni otro fantasma
            canvas.gh1[canvas.g1.y][canvas.g1.x] = 0;
            canvas.g1.y = canvas.g1.y - 1;//Cambio fila
            canvas.gh1[canvas.g1.y][canvas.g1.x] = 3;//Dibulo
        } else if (anterior == 2) {
            if (canvas.g1.owned) {
                canvas.gh1[canvas.g1.y][canvas.g1.x] = 0;
                canvas.g1.x = 12;
                canvas.g1.y = 15;
                canvas.gh1[15][12] = 3;
                canvas.g1.owned = false;
                ventana.npuntuacion += 200;
            } else if (canvas.g1.owned == false) {
                if (canvas.vidas <= 1) {
                    canvas.vidas = 0;
                } else {
                    vidaMenos();
                }
                ventana.npuntuacion -= 200;
            }
        }
    }

    private void derecha() {
        try {
            anterior = canvas.paredes[canvas.g1.y][canvas.g1.x + 1];
        } catch (Exception e) {
            anterior = 17;
        }
        if ((anterior != 7) && (anterior != 8) && (anterior != 9) && (anterior != 11)
                && (anterior != 12) && (anterior != 13) && (anterior != 14) && (anterior != 15)
                && (anterior != 16) && noFantasma(canvas.gh1[canvas.g1.y][canvas.g1.x + 1],
                        canvas.gh2[canvas.g1.y][canvas.g1.x + 1],
                        canvas.gh3[canvas.g1.y][canvas.g1.x + 1],
                        canvas.gh4[canvas.g1.y][canvas.g1.x + 1])) {//Si no hay muro
            try {
                canvas.gh1[canvas.g1.y][canvas.g1.x] = 0;
                canvas.g1.x = canvas.g1.x + 1;//Cambio fila
                canvas.gh1[canvas.g1.y][canvas.g1.x] = 3;//Dibulo
            } catch (Exception e) {
                canvas.g1.x = canvas.g1.x - 1;
                canvas.paredes[canvas.g1.y][canvas.g1.x] = 17;
                canvas.g1.x = canvas.g1.x - 27;
                canvas.gh1[canvas.g1.y][canvas.g1.x] = 3;//Dibulo
            }
        } else if (anterior == 2) {
            if (canvas.g1.owned) {
                canvas.gh1[canvas.g1.y][canvas.g1.x] = 0;
                canvas.g1.x = 12;
                canvas.g1.y = 15;
                canvas.gh1[15][12] = 3;
                canvas.g1.owned = false;
                ventana.npuntuacion += 200;
            } else if (canvas.g1.owned == false) {
                if (canvas.vidas <= 1) {
                    canvas.vidas = 0;
                } else {
                    vidaMenos();
                }
                ventana.npuntuacion -= 200;
            }
        }
    }

    private void abajo() {
        anterior = canvas.paredes[canvas.g1.y + 1][canvas.g1.x];
        if ((anterior != 7) && (anterior != 8) && (anterior != 9) && (anterior != 11)
                && (anterior != 12) && (anterior != 13) && (anterior != 14) && (anterior != 15)
                && (anterior != 16) && noFantasma(canvas.gh1[canvas.g1.y + 1][canvas.g1.x],
                        canvas.gh2[canvas.g1.y + 1][canvas.g1.x],
                        canvas.gh3[canvas.g1.y + 1][canvas.g1.x],
                        canvas.gh4[canvas.g1.y + 1][canvas.g1.x])) {//Si no hay muro
            canvas.gh1[canvas.g1.y][canvas.g1.x] = 0;
            canvas.g1.y = canvas.g1.y + 1;//Cambio fila
            canvas.gh1[canvas.g1.y][canvas.g1.x] = 3;//Dibulo
        } else if (anterior == 2) {
            if (canvas.g1.owned) {
                canvas.gh1[canvas.g1.y][canvas.g1.x] = 0;
                canvas.g1.x = 12;
                canvas.g1.y = 15;
                canvas.gh1[15][12] = 3;
                canvas.g1.owned = false;
                ventana.npuntuacion += 200;
            } else if (canvas.g1.owned == false) {
                if (canvas.vidas <= 1) {
                    canvas.vidas = 0;
                } else {
                    vidaMenos();
                }
                ventana.npuntuacion -= 200;
            }
        }
    }

    private void izquierda() {
        try {
            anterior = canvas.paredes[canvas.g1.y][canvas.g1.x - 1];
        } catch (Exception e) {
            anterior = 18;
        }
        if ((anterior != 7) && (anterior != 8) && (anterior != 9) && (anterior != 11)
                && (anterior != 12) && (anterior != 13) && (anterior != 14) && (anterior != 15)
                && (anterior != 16) && noFantasma(canvas.gh1[canvas.g1.y][canvas.g1.x - 1],
                        canvas.gh2[canvas.g1.y][canvas.g1.x - 1],
                        canvas.gh3[canvas.g1.y][canvas.g1.x - 1],
                        canvas.gh4[canvas.g1.y][canvas.g1.x - 1])) {//Si no hay muro
            try {
                canvas.gh1[canvas.g1.y][canvas.g1.x] = 0;
                canvas.g1.x = canvas.g1.x - 1;//Cambio fila
                canvas.gh1[canvas.g1.y][canvas.g1.x] = 3;//Dibulo
            } catch (Exception e) {
                canvas.g1.x = canvas.g1.x + 1;
                canvas.paredes[canvas.g1.y][canvas.g1.x] = 17;
                canvas.g1.x = canvas.g1.x + 27;
                canvas.gh1[canvas.g1.y][canvas.g1.x] = 3;//Dibulo
            }
        } else if (anterior == 2) {
            if (canvas.g1.owned) {
                canvas.gh1[canvas.g1.y][canvas.g1.x] = 0;
                canvas.g1.x = 12;
                canvas.g1.y = 15;
                canvas.gh1[15][12] = 3;
                canvas.g1.owned = false;
                ventana.npuntuacion += 200;
            } else if (canvas.g1.owned == false) {
                if (canvas.vidas <= 1) {
                    canvas.vidas = 0;
                } else {
                    vidaMenos();
                }
                ventana.npuntuacion -= 200;
            }
        }
    }

    private boolean noFantasma(int f1, int f2, int f3, int f4) {
        if (f1 != 3 && f2 != 4 && f3 != 5 && f4 != 6) {
            return true;
        }
        return false;
    }

    private void vidaMenos() {
        canvas.vidas--;
        canvas.gh1[canvas.g1.y][canvas.g1.x] = 0;
        canvas.g1.x = 12;
        canvas.g1.y = 15;
        canvas.gh1[15][12] = 3;
        canvas.gh2[canvas.g2.y][canvas.g2.x] = 0;
        canvas.g2.x = 13;
        canvas.g2.y = 15;
        canvas.gh2[15][13] = 4;
        canvas.gh3[canvas.g3.y][canvas.g3.x] = 0;
        canvas.g3.x = 14;
        canvas.g3.y = 15;
        canvas.gh3[15][14] = 5;
        canvas.gh4[canvas.g4.y][canvas.g4.x] = 0;
        canvas.g4.x = 15;
        canvas.g4.y = 15;
        canvas.gh4[15][15] = 6;
        canvas.paredes[canvas.pacman.y][canvas.pacman.x] = 0;
        canvas.pacman.x = 13;
        canvas.pacman.y = 23;
        canvas.paredes[23][13] = 2;
    }
}