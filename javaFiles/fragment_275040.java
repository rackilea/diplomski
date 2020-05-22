String[] Lista;
        String[] nombre = {"Acosta Ochoa Sebastian", "Aguilar Gomez Jesus", "Alejandro Suarez Lidia", "Arevalo Alvarez Ezequiel", "Arias Varela Jair Eli", "Chacon Martinez Michael", "Cordova Contreras Gabriela Yajaira", "Cruz Dominguez Juan Carlos", "Delgado Rodriguez Daniel Raul", "Gallardo Echeverria Isaac Dali", "Gil Bautista Francisco Javier", "Gonzalez Hernandez Anabel", "Lopez Martinez Yesenia Eloisa", "Lopez Pablo Marcos Antonio", "Mendoza Rueda Saul", "Nadal Salaya Juan Carlos", "Ramirez Aguirre Jorge Luis ", "Ramos Ramos Adrian Adair", "Rodriguez Landero Alfredo", "Salaya Cruz Aaron", "Santos Meza Jonathan", "Solis Hernandez Marcel", "Solis Pereyra Alan", "Solis Pereyra Pedro Antonio", "Valencia Salaya Alexander", "Zapata Foster Aylin"};

        int TAM_ARRAY = nombre.length;

        Random rand = new Random();

        int posAleatoria = rand.nextInt(TAM_ARRAY)+1;//TAM_ARRAY is the maximum and the 1 is our minimum

        String str = nombre[posAleatoria];
        System.out.println(str);