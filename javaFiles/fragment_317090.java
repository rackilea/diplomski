double[][] E = null;
for (int i = 0; i < Nb_Layers - 1; i++) {
    System.out.println("Enter the length of layer" + (i + 1) + ":");
    Hidden_layer_len[i] = in.nextInt();

    if (i == 0) {
        E = new double[Hidden_layer_len[i]][1];
    }
}