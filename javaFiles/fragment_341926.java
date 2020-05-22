private void filtrarPor(String especialidad){
        Scanner sc;
        Especialista aux;
        StringTokenizer st;

        try {
            sc = new Scanner (especialistas);
            sc.nextLine();
            while (sc.hasNextLine()) {
                st = new StringTokenizer(sc.nextLine(), ";"); 
                if(st.countTokens() >= 7) { //skip not valid Especialista

                    aux = new Especialista (st.nextToken(), st.nextToken(), st.nextToken(),
                        st.nextToken(), st.nextToken(), st.nextToken(),new ImageIcon(Pacientes.class.getResource(st.nextToken())));

                    if(aux.getEspecialidade().equals(especialidad))
                        modelo.addElement(aux);

                }
            }
            listEspecialistas.setModel(modelo);//you can set the model with your list after everything is loaded
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    } 
}