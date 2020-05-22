List<Sentence> result = new ArrayList<Sentence>();
result.add( new Sentence() ); // start with an empty sentence

for( WordList words : wordLists ) {
    List<Sentence> tmp = new ArrayList<Sentence>();

    for( Sentence s : result ) {
        tmp.addAll( s.appendWords( words ) );
    }

    result = tmp;
}