jshell> String a = "abc      def";
a ==> "abc      def"

jshell> a = a.replaceAll("\\s+", " ");
a ==> "abc def"

jshell> String a = "abc            def";
a ==> "abc            def"

jshell> a = a.replaceAll("\\s+", " ");
a ==> "abc def"