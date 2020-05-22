int choice =
    TaskDialogs
        .build( owner, "What do you think?",
            "You have to choose, either this dialog looks good or it just sucks!" )
        .title( "Make a decision!" )
        .choice( 0,
            new CommandLink( "Looks good", "With good I mean it looks reaaaally awesome!" ),
            new CommandLink( "It sucks", "I cant see it anymore, take it away!" ) );