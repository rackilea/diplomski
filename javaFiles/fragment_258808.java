public static void main(String[] args) {
        // TODO code application logic here

        int ammo = 5;
        Gun g1 = new Gun("MK16", "Bang!", 10,15,5,5,5);

        g1.fire();
        ammo = g1.reload(ammo);
        System.out.println("Ammo left: " + ammo);
        System.out.println("Bullets left: " + g1.bulletsRemaining);


    }