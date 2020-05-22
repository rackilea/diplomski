for(int a=0; a<list_input.size(); a++)
        {
            for(int b=0; b<list_input.size(); b++) {
                String chemin = list_input.get(a);
                if(a != b)
                {
                    String chemin_comparé = list_input.get(b);
                    while(true) {
                        if(chemin_comparé.indexOf(chemin) != -1 && !list_output.contains(chemin))
                            list_output.add(chemin);
                        if(chemin.contains("/")) {
                            chemin = chemin.substring(0, chemin.lastIndexOf("/"));
                        } else {
                            break;
                        }
                    };
                }
            }
        }