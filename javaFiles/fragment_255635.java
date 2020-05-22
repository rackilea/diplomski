%module Example

     %{
       int func(const unsigned char *data);
      %}


      %include <arrays_java.i>

      %apply signed char[] { const unsigned char *data};


      int func(const unsigned char *data);