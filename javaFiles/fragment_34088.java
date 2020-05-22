interface JsonBuilder {
   String getString(Object input);
}

class SimpleBuilder implements JsonBuilder 
// does what your "non-pretty print code" does

class PrettyBuilder implements JsonBuilder
// does the other thing