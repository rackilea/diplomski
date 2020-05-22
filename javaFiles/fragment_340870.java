public void parseFileContent() {
    List<String> lines = new FileInput().readFile();

    try {
        for (String line : lines) {
            String[] elements = line.split("/"); 
            /* Note: For each line elements[0]=movie, elements[1]=actor1, elements[2]=actor2 */

            // Creating and adding movie edge
            MovieEdge me = findMovieByName(allmovies, elements[0]);
            if (me == null) {
                me = new MovieEdge(elements[0]);
                allmovies.add(me);
            }

            // Creating and adding actor vertices
            ActorVertex av1 = findActorByName(allactors, elements[1]);
            if (av1 == null) {
                av1 = new ActorVertex(elements[1]);
                allactors.add(av1);
            }
            ActorVertex av2 = findActorByName(allactors, elements[2]);
            if (av2 == null) {
                av2 = new ActorVertex(elements[2]);
                allactors.add(av2);
            }

            /*** Joining the actor vertices with movie edge to construct the graph for each line ***/

            /* Associating actors/actresses with movie in which they have played a role */
            me.joinActorVertex(av1); // associating 1st actor/actress with its corresponding movie
            if (av2 != null) { // checking if actor2 exists for the movie. If so the associate him/her with the
                               // movie.
                me.joinActorVertex(av2);
            }

            /* Linking corresponding movie edge to actors */
            av1.addMovieEdge(me);
            if (av2 != null) { // Again, checking if actor2 exists for the movie. If so the associate him/her with
                               // the movie.
                av2.addMovieEdge(me);
            }

        }

    } catch (Exception e) {
        System.out.println(e.getMessage());

    }

}

private ActorVertex findActorByName(List<ActorVertex> avs, String name) {
    for (ActorVertex av : avs) {
        if (av.getName().equals(name)) {
            return av;
        }
    }
    return null;
}

public MovieEdge findMovieByName(List<MovieEdge> mes, String name) {
    for (MovieEdge me : mes) {
        if (me.getName().equals(name)) {
            return me;
        }
    }
    return null;
}