#macro( ccase $str )
#foreach( $word in $str.split('-') )$word.substring(0,1).toUpperCase()$word.substring(1)#end
#end
#set( $classNamePrefix = "#ccase( $artifactId )" )

public class ${classNamePrefix}Application {
    // ...
}