default domain Java~v7;

 pattern any_method(p: path_to_name, name: method_name, args: arguments,
                    b: body, a: annotations):declaration =
    " \p \name(\args) \a \b ";  -- doesn't handle non-functions but easily adjusted

 pattern TestClass(p: path_to_name, name: method_name, args: arguments,
                    b: body, a: annotations):declaration =
    " \p \name(\args) [Test.class] \b ";

 pattern abcdef_identifier():IDENTIFIER =
      "abcdef";

 rule insert_MyAnnotation(p: path_to_name, name: method_name, args: arguments,
                          b: body, a: annotations):declaration =
    " \p \name(\args) \a \b "
    ->
    " \p \name(\args) \a [myAnnotation] \b ";