StringBuilder builder= new StringBuilder();
builder.append("[");
builder.append("  {");
builder.append("    \"validation\" : {");
// ...

// When finished:
response.getWriter().write(builder.toString());