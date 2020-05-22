#Keeping all public class names and keep (prevent obfuscation) of their public and protected methods
-keep public class * {
    public protected <methods>;
}

# Keep (prevent obfuscation) all public and protected methods in non-public classes.
# Notice that the non-public class names will still get obfuscated
-keepclassmembers !public class * {
    public protected <methods>;
}

# Don't keep the local variables attributes (LocalVariableTable and LocalVariableTypeTable are dropped).
-keepattributes Exceptions,Signature,Deprecated,SourceFile,SourceDir,LineNumberTable,Synthetic,EnclosingMethod,RuntimeVisibleAnnotations,RuntimeInvisibleAnnotations,RuntimeVisibleParameterAnnotations,RuntimeInvisibleParameterAnnotations,AnnotationDefault,InnerClasses,*Annotation*