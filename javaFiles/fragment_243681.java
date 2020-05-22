List<Cidade> cidades = new ArrayList<>();
    for ( Cidade cidade : cidades ) {
        System.out.println(cidade.getName());
        ArrayList<Vizinhos> vizinhosList = cidade.getVizinhos();
        for ( Vizinhos vizinhos : vizinhosList ) {
            System.out.println(vizinhos.getNamev());
            System.out.println(vizinhos.getDistancia().getReta());
            System.out.println(vizinhos.getDistancia().getRodovia());
        }
    }