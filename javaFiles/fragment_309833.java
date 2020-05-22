{{#isPrimitiveType}} 
  private {{{datatypeWithEnum}}} {{name}} = {{{defaultValue}}};
{{/isPrimitiveType}}
{{^isPrimitiveType}}
  private {{{datatypeWithEnum}}} {{name}} = new {{{datatypeWithEnum}}}();
{{/isPrimitiveType}}