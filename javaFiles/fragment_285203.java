...
lexer.removeErrorListeners();
lexer.addErrorListener(MyAntlrErrorListener.INSTANCE);
parser.removeErrorListeners();
parser.addErrorListener(MyAntlrErrorListener.INSTANCE);

...

return MyAntlrErrorListener.INSTANCE.toString();