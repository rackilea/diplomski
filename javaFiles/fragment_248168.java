expression returns [TLNode node]
  :  ^(TERNARY a=expression b=expression c=expression) {node = new TernaryNode($a.node, $b.node, $c.node);}
  |  ^(In a=expression b=expression)                   {node = new InNode($a.node, $b.node);}
  |  ^('||' a=expression b=expression)                 {node = new OrNode($a.node, $b.node);}
  |  ^('&&' a=expression b=expression)                 {node = new AndNode($a.node, $b.node);}
  |  ^('==' a=expression b=expression)                 {node = new EqualsNode($a.node, $b.node);}
  |  ^('!=' a=expression b=expression)                 {node = new NotEqualsNode($a.node, $b.node);}
  |  ^('>=' a=expression b=expression)                 {node = new GTEqualsNode($a.node, $b.node);}
  |  ^('<=' a=expression b=expression)                 {node = new LTEqualsNode($a.node, $b.node);}
  |  ^('>' a=expression b=expression)                  {node = new GTNode($a.node, $b.node);}
  |  ^('<' a=expression b=expression)                  {node = new LTNode($a.node, $b.node);}
  |  ^('+' a=expression b=expression)                  {node = new AddNode($a.node, $b.node);}
  |  ^('-' a=expression b=expression)                  {node = new SubNode($a.node, $b.node);}
  |  ^('*' a=expression b=expression)                  {node = new MulNode($a.node, $b.node);}
  |  ^('/' a=expression b=expression)                  {node = new DivNode($a.node, $b.node);}
  |  ^('%' a=expression b=expression)                  {node = new ModNode($a.node, $b.node);}
  |  ^('^' a=expression b=expression)                  {node = new PowNode($a.node, $b.node);}
  |  ^(UNARY_MIN a=expression)                         {node = new UnaryMinusNode($a.node);}
  |  ^(NEGATE a=expression)                            {node = new NegateNode($a.node);}
  |  Number                                            {node = new AtomNode(Double.parseDouble($Number.text));}
  |  Bool                                              {node = new AtomNode(Boolean.parseBoolean($Bool.text));}
  |  Null                                              {node = new AtomNode(null);}
  |  lookup                                            {node = $lookup.node;}
  |  ^(Input String?)                                  {node = new InputNode($String.text);} // added this line
  ;