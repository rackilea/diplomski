grammar Sequence;

parse : line+;
line : '{TEXT="' a=sequence '"}' {System.out.println(((LineContext)_localctx).a.getText());};
sequence : .+?;

ANY:.;